package bitcamp.java142.ch5.ldbjf.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import bitcamp.java142.ch5.ldbjf.dao.LdbMemberDAO;
import bitcamp.java142.ch5.ldbjf.dao.LdbMemberDAOImpl;
import bitcamp.java142.ch5.ldbjf.vo.LdbMemberVO;
import bitcamp.java142.common.utils.FilePath;

/**
 * Servlet implementation class BoardControllerServlet
 */
@WebServlet("/MemberControllerServlet")
public class MemberControllerServlet extends HttpServlet {
   private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberControllerServlet() {
    }

   /**
    * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
    */
   public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      // TODO Auto-generated method stub
      doPost(request,response );
      
   }

   /**
    * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
    */
   public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      // TODO Auto-generated method stub
      
      request.setCharacterEncoding("EUC-KR");
      response.setContentType("text/html;charset=EUC-KR");
      
      String lmem ="";
      String lname = "";
      String lid = "";
      String lpw = "";
      String lhp = "";
      String lbirth = "";
      String lemail = "";
      String lpostno = "";
      String lloadAddr = "";
      String laddr = "";
      String ldeleteYN ="";
      String linsertdate = "";
      String lupdatedate = "";
      String lphoto = "";
      
      
      PrintWriter out = response.getWriter();
      
      
      if(!request.getContentType().toLowerCase().startsWith("multipart/form-data")){
          //로그인
          
          lid = request.getParameter("lid");
          lpw = request.getParameter("lpw");
          System.out.println(lid + " : " +  lpw);
          
          LdbMemberDAO ldao = new LdbMemberDAOImpl();
          LdbMemberVO lvo = null;
          lvo = new LdbMemberVO();
          lvo.setLid(lid);
          lvo.setLpw(lpw);
          
          System.out.println( lvo.getLid() + " : " +  lvo.getLpw());
          
          ArrayList<LdbMemberVO> aList = ldao.loginLdbMember(lvo);
          
          String ISUD = request.getParameter("ISUD");
          
          
    	  
	      if("L".equals(ISUD.toUpperCase())){
	      
	    	  //로그인
	          if(aList.size()==1){
	              System.out.print("파일이 없는 로그인 성공!");
	              
	              request.setAttribute("lid", lid);
	              request.setAttribute("lpw", lpw);
	                
	              RequestDispatcher rd = request.getRequestDispatcher("/login/loginOK.jsp");
	              rd.forward(request, response);
	          }
	          
	          if(aList.size()!=1) {
	              System.out.println("로그인 실패!");
	              RequestDispatcher rd = request.getRequestDispatcher("/login/login.jsp");
	              rd.forward(request, response);
	          }
	      }
      
      
          //회원정보 수정
          if("U".equals(ISUD.toUpperCase())){
        	  System.out.println("업데이트 구문 들어감");
        	  
        	  lid = request.getParameter("lid");
        	  lpw = request.getParameter("lpw");
        	  
        	  
        	  LdbMemberVO lvo_S = new LdbMemberVO();
        	  lvo_S.setLid(lid);
        	  lvo_S.setLpw(lpw);
        	  
        	  aList = ldao.searchLdbMember(lvo_S);
        	  
              lvo = aList.get(0);
              
              lmem = lvo.getLmem();
              lname = lvo.getLname();
              lid = lvo.getLid();
              lpw = lvo.getLpw();
              lhp = lvo.getLhp();
              lbirth = lvo.getLbirth();
              lemail = lvo.getLemail();
              lpostno = lvo.getLpostno();
              lloadAddr = lvo.getLloadAddr();
              laddr = lvo.getLaddr();
              lphoto = lvo.getLphoto();
              
              System.out.println(lname + lid + lpw + lhp + lbirth + lemail + lpostno + lloadAddr + laddr+lphoto);
              
              ArrayList<String> sList = new ArrayList<String>();
              sList.add(lmem);
              sList.add(lname);
              sList.add(lid);
              sList.add(lpw);
              sList.add(lhp);
              sList.add(lbirth);
              sList.add(lemail);
              sList.add(lpostno);
              sList.add(lloadAddr);
              sList.add(laddr);
              sList.add(lphoto);
              
              
              request.setAttribute("sList", sList);
              
              
              RequestDispatcher rd = request.getRequestDispatcher("/login/updateMember.jsp");
              rd.forward(request, response);
          }
          //회원탈퇴시
          if("D".equals(ISUD.toUpperCase())){
        	  
        	  System.out.println("탈퇴 구문 들어감");
        	  
        	  lid = request.getParameter("lid");
        	  lpw = request.getParameter("lpw");
        	  
        	  
        	  LdbMemberVO lvo_S = new LdbMemberVO();
        	  lvo_S.setLid(lid);
        	  lvo_S.setLpw(lpw);
        	  
        	  aList = ldao.searchLdbMember(lvo_S);
        	  
              lvo = aList.get(0);
              
              lmem = lvo.getLmem();
              lname = lvo.getLname();
              lid = lvo.getLid();
              lpw = lvo.getLpw();
              lhp = lvo.getLhp();
              lbirth = lvo.getLbirth();
              lemail = lvo.getLemail();
              lpostno = lvo.getLpostno();
              lloadAddr = lvo.getLloadAddr();
              laddr = lvo.getLaddr();
              lphoto = lvo.getLphoto();
              
              System.out.println(lname + lid + lpw + lhp + lbirth + lemail + lpostno + lloadAddr + laddr+lphoto);
              
              ArrayList<String> sList = new ArrayList<String>();
              sList.add(lmem);
              sList.add(lname);
              sList.add(lid);
              sList.add(lpw);
              sList.add(lhp);
              sList.add(lbirth);
              sList.add(lemail);
              sList.add(lpostno);
              sList.add(lloadAddr);
              sList.add(laddr);
              sList.add(lphoto);
              
              request.setAttribute("sList", sList);
              
              RequestDispatcher rd = request.getRequestDispatcher("/login/deleteMember.jsp");
              rd.forward(request, response);
          
        	  
          }

      }else if(request.getContentType().toLowerCase().startsWith("multipart/form-data")){
         //회원가입
         
         LdbMemberDAO ldao = new LdbMemberDAOImpl();
         LdbMemberVO lvo = null;
         lvo = new LdbMemberVO();

         int size = 1024*1024*15;
         
         String fileName = "";
         
         System.out.println("이미지 파일이 있는 경우");
         
         try{
            
            System.out.println("try 진입");
            MultipartRequest mr = new MultipartRequest(  request, 
			                                             FilePath.UPLOAD_FILEPATH, 
			                                             size, 
			                                             "EUC-KR", 
			                                             new DefaultFileRenamePolicy());
             String ISUD = mr.getParameter("ISUD");
          
	   	      if("L".equals(ISUD.toUpperCase())){
	   	    	  
	   	    	 System.out.println("이미지 로그인");

                lid = mr.getParameter("lid");
                lpw = mr.getParameter("lpw");
                
                
	            System.out.println(lid + " : " +  lpw);
	            
	            ldao = new LdbMemberDAOImpl();
	            lvo = new LdbMemberVO();
	            lvo.setLid(lid);
	            lvo.setLpw(lpw);
	            
	            System.out.println( lvo.getLid() + " : " +  lvo.getLpw());
	            
	            ArrayList<LdbMemberVO> aList = ldao.loginLdbMember(lvo);
	           
	   	    	  //로그인
	   	          if(aList.size()==1){
 	                System.out.print("이미지 파일이 있는 로그인 성공!");
 	                
 	                request.setAttribute("lid", lid);
 	                request.setAttribute("lpw", lpw);
 	                
                    RequestDispatcher rd = request.getRequestDispatcher("/login/loginOK.jsp");
                    rd.forward(request, response);
		              
	   	          }
	   	          
	   	          if(aList.size()!=1) {
	   	              System.out.println("로그인 실패!");
//	   	              RequestDispatcher rd = request.getRequestDispatcher("../login/login.jsp");
//	   	              rd.forward(request, response);
	   	              
	   	           response.sendRedirect("../login/login.jsp");
	   	          }
	   	      }
   	      
            
            if("I".equals(ISUD.toUpperCase())){
            
               System.out.println(">>>회원가입 진입");
               Enumeration en = mr.getFileNames();
                     
               fileName = (String)en.nextElement();
               System.out.println("fileName" + fileName);
                     
               String fileInput = mr.getFilesystemName(fileName);
               lphoto = FilePath.DOWNLOAD_FILEPATH + fileInput;
               
               System.out.println("fileInput" + fileInput);
               System.out.println("lphoto" + lphoto);
               
               lname = mr.getParameter("lname");
               lid = mr.getParameter("lid");
               lpw = mr.getParameter("lpw");
               lhp = mr.getParameter("lhp");
               lbirth = mr.getParameter("lbirth");
               lemail = mr.getParameter("lemailId") + "@" + mr.getParameter("selectEmail");
               lpostno = mr.getParameter("lpostno");
               lloadAddr =  mr.getParameter("lloadAddr");
               laddr =  mr.getParameter("laddr");

               System.out.println(lname + lid + lpw + lhp + lbirth + lemail + lpostno + lloadAddr + laddr );
            
               lvo.setLname(lname);
               lvo.setLid(lid);
               lvo.setLpw(lpw);
               lvo.setLhp(lhp);
               lvo.setLbirth(lbirth);
               lvo.setLemail(lemail);
               lvo.setLpostno(lpostno);
               lvo.setLloadAddr(lloadAddr);
               lvo.setLaddr(laddr);
               lvo.setLphoto(lphoto);

               System.out.println("lvo.getLname; " + lvo.getLname());
               
               boolean bFlag = ldao.insertLdbMember(lvo);
               
               if(bFlag){
                  response.sendRedirect("/babyServlet/login/insertOK.jsp");
                  
               }else{
                  response.sendRedirect("/babyServlet/login/member.jsp");
      
               }
            
            }
            
            //모두 출력하기
            if("S".equals(ISUD.toUpperCase())){
               
               System.out.println("select문 진입하기");
               
               lvo = new LdbMemberVO();
               ArrayList<LdbMemberVO> aList = ldao.selectLdbMember();
               System.out.println("(log) aListAll >>> " + aList );
               request.setAttribute("aList", aList);
           	
			   RequestDispatcher rd = request.getRequestDispatcher("/login/selectMember.jsp");
			   rd.forward(request, response);
               
            }//end of select
            
            //정보 수정하기
            if("U".equals(ISUD.toUpperCase())){
            	
            	System.out.println("수정 서블릿 진입");
            	
                System.out.println("MultipartRequest>> 진입");
                Enumeration en = mr.getFileNames();
                      
                fileName = (String)en.nextElement();
                System.out.println("fileName" + fileName);
                String checkLpw = "";
                String fileInput = mr.getFilesystemName(fileName);
                lphoto = FilePath.DOWNLOAD_FILEPATH + fileInput;
                
                System.out.println("fileInput" + fileInput);
                System.out.println("lphoto" + lphoto);
          	  
                lmem = mr.getParameter("lmem");
                lname = mr.getParameter("lname");
                lid = mr.getParameter("lid");
                lpw = mr.getParameter("lpw");
                checkLpw = mr.getParameter("checkLpw");
                lhp = mr.getParameter("lhp");
                lbirth = mr.getParameter("lbirth");
                lemail = mr.getParameter("lemailId") + "@" + mr.getParameter("selectEmail");
                lpostno = mr.getParameter("lpostno");
                lloadAddr = mr.getParameter("lloadAddr");
                laddr =  mr.getParameter("laddr");

                
                System.out.println(lmem + lname + lid + lpw + lhp + lbirth + lemail + lpostno + lloadAddr + laddr );
                
                lvo.setLmem(lmem);
                lvo.setLname(lname);
                lvo.setLid(lid);
                lvo.setLpw(lpw);
                lvo.setCheckLpw(checkLpw);
                lvo.setLhp(lhp);
                lvo.setLbirth(lbirth);
                lvo.setLemail(lemail);
                lvo.setLpostno(lpostno);
                lvo.setLloadAddr(lloadAddr);
                lvo.setLaddr(laddr);
                lvo.setLphoto(lphoto);

                System.out.println("alert(lvo.getLname); " + lvo.getLname());
                
                boolean bFlag = ldao.updateLdbMember(lvo);
                
                //수정 후 돌아가기
                if(bFlag){
              	  
              	  	System.out.println(lid + lpw);
              	  
              	  	LdbMemberVO lvo_S = new LdbMemberVO();
              	  	lvo_S.setLid(lid);
              	  	lvo_S.setLpw(lpw);
              	  
              	  	System.out.println(lvo_S.getLid() + lvo_S.getLpw());
              	  	
              	  	ArrayList<LdbMemberVO> aList = null;
              	  	aList = ldao.searchLdbMember(lvo_S);
              	  
                    lvo = aList.get(0);
                    
                    lmem = lvo.getLmem();
                    lname = lvo.getLname();
                    lid = lvo.getLid();
                    lpw = lvo.getLpw();
                    lhp = lvo.getLhp();
                    lbirth = lvo.getLbirth();
                    lemail = lvo.getLemail();
                    lpostno = lvo.getLpostno();
                    lloadAddr = lvo.getLloadAddr();
                    laddr = lvo.getLaddr();
                    lphoto = lvo.getLphoto();
                    
                    System.out.println(lname + lid + lpw + lhp + lbirth + lemail + lpostno + lloadAddr +  laddr );
                    
                	Object obj = request.getAttribute("sList");//오브젝트로 받아옴
                		
                    ArrayList<String> sList = new ArrayList<String>();
                    sList.add(lmem);
                    sList.add(lname);
                    sList.add(lid);
                    sList.add(lpw);
                    sList.add(lhp);
                    sList.add(lbirth);
                    sList.add(lemail);
                    sList.add(lpostno);
                    sList.add(lloadAddr);
                    sList.add(laddr);
                    sList.add(lphoto);
                    
                    
                    request.setAttribute("sList", sList);
                    
                    
                    RequestDispatcher rd = request.getRequestDispatcher("/login/updateMember.jsp");
                    rd.forward(request, response);
                   
                }else{
                	System.out.println("정보 수정 실패");
                	response.sendRedirect("/login/loginOK.jsp");
                  
                }
                
            }//end of update
            
            //회원탈퇴하기
            if("D".equals(ISUD.toUpperCase())){
            	
            	System.out.println("삭제 서블릿 진입");
            	
            	String checkLpw = "";
            	
                lid = mr.getParameter("lid");
                lpw = mr.getParameter("lpw");// 로그인시 사용한 비밀번호 정보
                checkLpw = mr.getParameter("checkLpw"); //사용자가 탈퇴하기 위해 입력한 비밀번호

                lvo.setLid(lid);
                lvo.setLpw(checkLpw);

                System.out.println("lvo.getLid " + lvo.getLid());
                
                boolean bFlag = ldao.deleteLdbMember(lvo);
            	
                if(bFlag){
                		 
                	System.out.println("탈퇴 성공");  
                	lid="";
                	lpw="";
  	              	RequestDispatcher rd = request.getRequestDispatcher("/login/deleteOK.jsp");
  	              	rd.forward(request, response);
                	
                }else{
                	 System.out.println("탈퇴 실패");
           	   	  
	               	 ArrayList<LdbMemberVO> aList = ldao.loginLdbMember(lvo); 
	               	  
	               	 LdbMemberVO lvo_S = new LdbMemberVO();
	               	 lvo_S.setLid(lid);
	               	 lvo_S.setLpw(lpw);
               	  
               	  	 aList = ldao.searchLdbMember(lvo_S);
               	  
                     lvo = aList.get(0);
	 
					 lmem = lvo.getLmem();
					 lname = lvo.getLname();
					 lid = lvo.getLid();
					 lpw = lvo.getLpw();
					 lhp = lvo.getLhp();
					 lbirth = lvo.getLbirth();
					 lemail = lvo.getLemail();
					 lpostno = lvo.getLpostno();
		             lloadAddr = lvo.getLloadAddr();
		             laddr = lvo.getLaddr();
					 lphoto = lvo.getLphoto();
					 
					 System.out.println(lmem + lname + lid + lpw + lhp + lbirth + lemail + lpostno +  lloadAddr + laddr );
					 
					 ArrayList<String> sList = new ArrayList<String>();
					 sList.add(lmem);
					 sList.add(lname);
					 sList.add(lid);
					 sList.add(lpw);
					 sList.add(lhp);
					 sList.add(lbirth);
					 sList.add(lemail);
					 sList.add(lpostno);
					 sList.add(lloadAddr);
					 sList.add(laddr);
					 sList.add(lphoto);
					 
					 request.setAttribute("sList", sList);
					 
					 RequestDispatcher rd = request.getRequestDispatcher("/login/deleteMember.jsp");
					 rd.forward(request, response);
                }
            	
            }//end of delete
            
         }catch(Exception e){
            e.getMessage();
         }
      }

   }
   
   public boolean checkId(String lid){
         
      System.out.println("(log)아이디 중복체크 서블릿 진입");
      LdbMemberDAO ldao = new LdbMemberDAOImpl();
      LdbMemberVO lvo = null;
      lvo = new LdbMemberVO();
      
      lvo.setLid(lid);
      
      boolean bool = ldao.idCheck(lvo);
      
      System.out.println("bool >>> : " + bool);
         
      return bool;
   }
   
}