package servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import dao.MusicDao;
import entity.Music;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA
 * Description:
 * User:LiWenYan
 * Date:2020-07-30
 * Time:19:11
 */
@WebServlet("/deleteSelMusicServlet")
public class DeleteSelMusicServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("application/json;charset=utf-8");
        //5 --> 批量删除怎么样算删除？全部删除成功
        String[] values = req.getParameterValues("id[]");
        //values数组当中存放的是所有需要删除的歌曲的id
        MusicDao musicDao = new MusicDao();
        int sum = 0;
        Map<String,Object> return_map = new HashMap<>();
        for(int i = 0;i < values.length; i++) {
            int id = Integer.parseInt(values[i]);
            Music music = musicDao.findMusicById(id);
            int delete = musicDao.deleteMusicById(id);
            if(delete == 1) {
                File file = new File("E:\\GitHub\\GitHub\\learn-java\\wuliMusic\\web\\"+music.getUrl()+".mp3");
                if (file.delete()) {
                    //System.out.println("服务器删除成功！");
                    sum += delete;
                }else {
                    return_map.put("msg",false);
                    System.out.println("服务器删除失败！");
                }
            }else {
                return_map.put("msg",false);
                System.out.println("数据库中数据删除失败！");
            }
        }
        if (sum == values.length) {
            return_map.put("msg",true);

        }else {
            return_map.put("msg",false);
            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(resp.getWriter(),return_map);
        }
    }
}
