package com.duongnguyen.Controller;

import com.duongnguyen.DAO.DAO;
import com.duongnguyen.Model.DauViec;
import com.duongnguyen.Model.NhanCong;
import jakarta.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@CrossOrigin
public class DauViecController {

private DAO DAO = new DAO();


@GetMapping("/dauviec")
  public String getAllDauViec(Model model, @RequestParam(value = "keyword", required = false) String keyword){
  List<DauViec> list = DAO.getAllDauViec();

  if (keyword!=null) {
    list = DAO.searchDauViec(keyword);
  }
  model.addAttribute("dauviecs", list);
  return  "dauviecs";
}

  @GetMapping("/dauviec/{id}")
  public String getDauViec(Model model, @PathVariable int id) {
    model.addAttribute("id", id);
    DauViec dauviec = DAO.getDauViec(id);
    model.addAttribute("dauviec", dauviec);
    return "themdauviec";
  }

  @GetMapping("/suadauviec/{id}")
  public String getSuaDauViec(Model model, @PathVariable int id) {
    model.addAttribute("id", id);
    DauViec dauviec = DAO.getDauViec(id);
    model.addAttribute("dauviec", dauviec);
    return "suadauviec";
  }

  @PostMapping("/dauviec/delete/{id}")
  public String delete(@PathVariable String id) {
    DAO.delete(id);
    return "redirect:/dauviec";
  }


  @PostMapping("/suadauviec/update/{id}")
  public String updateDauViec(@ModelAttribute DauViec dauviec, @PathVariable String id) {

    try {
      DAO.updateDauViec(dauviec, id);
      System.out.println("update ok");
      return "redirect:/dauviec";
    } catch (Exception e) {
      System.out.println("Lỗi");
      return "error";
    }
  }

  @PostMapping("/dauviec/save/{id}")
    public String addDauViec(DauViec dauviec, @PathVariable String id) {
      DAO.addDauViec(dauviec);
      return "redirect:/dauviec";
    }


//    Liên quan đến việc làm
  //////////////////////////
@GetMapping("/nhancongdauviec/{id}")
public String getThemNhanCong(Model model, @PathVariable int id, @RequestParam(value = "keyword", required = false) String keyword) {
  model.addAttribute("id", id);
  DauViec dauviec = DAO.getDauViec(id);
  model.addAttribute("dauviec", dauviec);

  // Lấy danh sách nhân công làm đầu vệc
  List<NhanCong> list = DAO.getNhanCongsByDauViec(id);
  model.addAttribute("nhancongs", list);

  List<NhanCong> listnhancongavailable = new ArrayList<>();
  if (keyword!=null){
    // search danh sach nhan cong chua lam gi
    listnhancongavailable = DAO.searchNhanCongsAvailable(keyword);
  }else {
    // Lấy all danh sách nhân công chưa làm gì
    listnhancongavailable = DAO.getNhanCongsAvailable();
  }


  model.addAttribute("nhancongs_available", listnhancongavailable);
  return "nhancongdauviec";
}

// Xóa nhân công trong đầu việc và chuyển vể trang hiện tại
  @PostMapping("/nhancongdauviec/delete/{id}")
  public String deleteNhanCongInDauViec(@PathVariable String id, @RequestParam String iddauviec) {
    DAO.deleteNhanCongInDauViec(id);
    String yourSuccessPage = iddauviec;
    return "redirect:/nhancongdauviec/"+ yourSuccessPage;
  }

  //Thêm nhân công trong đầu việc và chuyển vể trang hiện tại
  @PostMapping("/nhancongdauviec/add")
  public String insertNhanCongInDauViec(@RequestParam String idnhancong, @RequestParam String iddauviec) {
    DAO.insertNhanCongDauViec(idnhancong, iddauviec);
    return "redirect:/nhancongdauviec/"+ iddauviec;
  }
}
