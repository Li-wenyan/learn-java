package service;

import dao.MusicDao;
import entity.Music;

import java.util.List;

/**
 * Created with IntelliJ IDEA
 * Description:
 * User:LiWenYan
 * Date:2020-07-29
 * Time:10:26
 */
public class MusicService {

    /*public int deleteMusicById(int id) {
        //在这里将方法嵌套，因为这层就是逻辑
        MusicDao musicDao = new MusicDao();
        if(musicDao.deleteMusicById(id) == 1) {
            if(musicDao.findLoveMusicOnDel(id)) {

            }
        }
    }*/

    public List<Music> findMusic() {
        MusicDao musicDao = new MusicDao();
        List<Music> musicList = musicDao.findMusic();
        return musicList;
    }
}
