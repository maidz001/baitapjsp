package service;

import dao.TinNhanDAO;
import model.TinNhan;

import java.util.List;

public class TinNhanService {
    private TinNhanDAO tinNhanDAO=new TinNhanDAO();
    public List<TinNhan> layTinNhanGiua2nguoi(int idnguoihui, int idnguoinhan){
        return tinNhanDAO.layTinNhanGiua2Nguoi(idnguoihui,idnguoinhan);
    }
}
