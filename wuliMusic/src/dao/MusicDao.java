package dao;

import com.mysql.jdbc.Connection;
import entity.Music;
import util.DBUtils;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA
 * Description:
 * 有关音乐的数据库操作
 * User:LiWenYan
 * Date:2020-07-26
 * Time:20:42
 */
public class MusicDao {
    //查询全部歌单
    public  List<Music> findMusic() {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Music> musicList = new ArrayList<>();
        try{
            String sql = "select * from music";
            connection = DBUtils.getConnection();
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Music music = new Music();
                music.setId(rs.getInt("id"));
                music.setTitle(rs.getString("title"));
                music.setSinger(rs.getString("singer"));
                music.setTime(rs.getDate("time"));
                music.setUrl(rs.getString("url"));
                music.setUserId(rs.getInt("userid"));
                musicList.add(music);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtils.getClose(connection, ps, null);
        }
        return musicList;
    }


     // 根据id 查找音乐
    public Music findMusicById(int id) {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        Music music = null;

        try{
            String sql = "select * from music where id=?";
            connection = DBUtils.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setInt(1,id);
            rs = ps.executeQuery();
            if(rs.next()) {
                music = new Music();
                music.setId(rs.getInt("id"));
                music.setTitle(rs.getString("title"));
                music.setSinger(rs.getString("singer"));
                music.setTime(rs.getDate("time"));
                music.setUrl(rs.getString("url"));
                music.setUserId(rs.getInt("userid"));
            }
        }catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtils.getClose(connection,ps,rs);
        }
        return music;
    }

    /*
    根据关键字查询歌单
    str:歌名
     */

    public List<Music> ifMusic(String str) {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Music> musicList = new ArrayList<>();
        try{
            String sql = "select * from music where title like '%" + str + "%'";
            connection = DBUtils.getConnection();
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Music music = new Music();
                music.setId(rs.getInt("id"));
                music.setTitle(rs.getString("title"));
                music.setSinger(rs.getString("singer"));
                music.setTime(rs.getDate("time"));
                music.setUrl(rs.getString("url"));
                music.setUserId(rs.getInt("userid"));
                musicList.add(music);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtils.getClose(connection,ps,rs);
        }
        return musicList;
    }

    //1，可以不给这么多参数
    //2,其实可以给一个Music对象
    // 上传音乐
    //a,上传文件本身给服务器
    //b，将音乐信息插入到数据库中，

    public int insert(String title, String singer, String time, String url,
                      int userid) {
        Connection connection = null;
        PreparedStatement ps = null;

        try{
            String sql = "insert into music(title, singer, time, url, userid) values (?,?,?,?,?)";
            connection = DBUtils.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setString(1,title);
            ps.setString(2,singer);
            ps.setString(3,time);
            ps.setString(4,url);
            ps.setInt(5,userid);
            int ret = ps.executeUpdate();
            //返回值代表当前受影响的行数
            if(ret == 1) {
                return 1;
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtils.getClose(connection,ps,null);
        }
        return 0;
    }

    /*
    删除歌曲信息

     */

    public int deleteMusicById(int id) {
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            String sql = "delete from music where id=?";
            connection = DBUtils.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setInt(1,id);
            int ret = ps.executeUpdate();
            if(ret == 1) {
                //说明删除歌曲信息成功
                if(findLoveMusicOnDel(id)) {
                    int ret2 = removeLoveMusicOnDel(id);
                    if(ret2 == 1) {
                        return 1;
                    }
                }
                return 1;//说明这首歌没有被添加到lovemusic这张表中
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtils.getClose(connection,ps,null);
        }
        return 0;
    }

    public boolean findLoveMusicOnDel(int id) {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String sql = "select * from lovemusic where id=?";
            connection = DBUtils.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setInt(1,id);
            rs = ps.executeQuery();
            if(rs.next()) {
                return true;
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtils.getClose(connection,ps,null);
        }
        return false;
    }
    public int removeLoveMusicOnDel(int id) {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int ret = 0;
        try {
            String sql = "delete from lovemusic where id=?";
            connection = DBUtils.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setInt(1,id);
            ret = ps.executeUpdate();
        }catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtils.getClose(connection,ps,null);
        }
        return ret;
    }

    /**
     * 添加喜欢的音乐的时候，需要先判断该音乐是否存在
     *  musicID
     *
     */
    public boolean findMusicByMusicId(int user_id,int musicID) {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int ret = 0;
        try {
            String sql = "select * from lovemusic where user_id=? and music_id=?";
            connection = DBUtils.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setInt(1,user_id);
            ps.setInt(2,musicID);
            rs = ps.executeQuery();
            if(rs.next()) {
                return true;
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtils.getClose(connection,ps,null);
        }
        return false;
    }

    /**
     * 添加音乐到“喜欢”列表中
     * 用户-》音乐
     * 多对多
     * 需要中间表
     */
    public  boolean insertLoveMusic(int userId, int musicId) {
        Connection connection = null;
        PreparedStatement ps = null;
        int ret = 0;
        try {
            String sql = "insert into lovemusic(user_id,music_id)values (?,?)";
            connection = DBUtils.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setInt(1,userId);
            ps.setInt(2,musicId);
            ret = ps.executeUpdate();
            if(ret == 1) {
                return true;
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtils.getClose(connection,ps,null);
        }
        return false;
    }

    /**
     * userId 用户id
    * musicId 歌曲id
    *  返回受影响的行数
    * 移除当前用户喜欢的这首音乐，因为同一首音乐可能多个用户喜欢
    */
    public int removeLoveMusic(int userId,int musicId) {
        Connection connection = null;
        PreparedStatement ps = null;
        int ret = 0;
        try {
            String sql = "delete from lovemusic where user_id=? and music_id=?";
            connection = DBUtils.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setInt(1,userId);
            ps.setInt(2,musicId);
            ret = ps.executeUpdate();
        }catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtils.getClose(connection,ps,null);
        }
        return ret;
    }

    /**
     * 查询用户喜欢的全部歌单
     * user_id
     *
     */
    public  List<Music> findLoveMusic(int user_id){
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Music> musicList = new ArrayList<>();
        try {
            String sql = "select m.id as music_id,title,singer,time,url,userid " +
                    "from lovemusic lm,music m where lm.music_id=m.id and user_id=?";
            connection = DBUtils.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setInt(1,user_id);
            rs = ps.executeQuery();
            while (rs.next()) {
                Music music = new Music();
                music.setId(rs.getInt("music_id"));
                music.setTitle(rs.getString("title"));
                music.setSinger(rs.getString("singer"));
                music.setTime(rs.getDate("time"));
                music.setUrl(rs.getString("url"));
                music.setUserId(rs.getInt("userid"));
                musicList.add(music);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtils.getClose(connection,ps,null);
        }
        return musicList;
    }

    /**
     * 根据关键字查询喜欢的歌单
     *  str
     *
     */
    public  List<Music> ifMusicLove(String str,int user_id){
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Music> musicList = new ArrayList<>();
        try {
            String sql = "select m.id as music_id,title,singer,time,url,userid " +
                    "from lovemusic lm,music m where lm.music_id=m.id and user_id=? and title like '%" + str +"%'";
            connection = DBUtils.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setInt(1,user_id);
            rs = ps.executeQuery();
            while (rs.next()) {
                Music music = new Music();
                music.setId(rs.getInt("music_id"));
                music.setTitle(rs.getString("title"));
                music.setSinger(rs.getString("singer"));
                music.setTime(rs.getDate("time"));
                music.setUrl(rs.getString("url"));
                music.setUserId(rs.getInt("userid"));
                musicList.add(music);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtils.getClose(connection,ps,null);
        }
        return musicList;
    }

   // public static void main(String[] args) {
        /*List<Music> musicList = findMusic();
        System.out.println(musicList);*/
       /* Music music = findMusicById(2);
        System.out.println(music);*/
       /*List<Music> musicList = ifMusic("姑");
        System.out.println(musicList);*/
       //Insert("给女孩","李宇春","1982-03-10","music\\给女孩 ",1);
        //System.out.println(deleteMusicById(1));
        //insertLoveMusic(1,2);
        //removeLoveMusic(1,2);
        /*List<Music> musicList = findLoveMusic(1);
        System.out.println(musicList);*/
       /* List<Music> musicList = ifMusicLove("女",1);
        System.out.println(musicList);*/

   // }
}
