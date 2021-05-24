package library;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class UserManager {
    private static File USER_FILE = new File("user.txt");
    protected Map<String, UserInfo> userMap;
    boolean userState = false; // 로그아웃 된 상태
    UserInfo currentLoginUser = null;

    public UserManager() {
        userMap = new HashMap<>();
        try {
            if(!USER_FILE.exists()){
                System.out.println("User 저장 파일이 없습니다.");
                return;
            }
            BufferedReader br = new BufferedReader(new FileReader(USER_FILE));
            String input = "";
            while ((input = br.readLine()) != null){
                String[] inputSplit = input.split("\t");
                String id = inputSplit[0];
                String pw = inputSplit[1];
                UserInfo newUserInfo = new UserInfo(id, pw);
                userMap.put(id, newUserInfo);
            }
            br.close();
        } catch(IOException e){
            e.printStackTrace();
        }
    }

    public Map<String, UserInfo> getUserMap() {
        return userMap;
    }

    //회원가입
    boolean register(String id, String pw) {
        
    	if (userMap.containsKey(id)) {
            System.out.println("이미 존재하는 ID 입니다.");
            return false;
        } else {
        	UserInfo user = new UserInfo(id, pw);
            userMap.put(id, user);
            System.out.println("회원가입에 성공했습니다.");
            System.out.println(user.getId() + "님 환영합니다.");
            return true;	
        }
        
    }

    //로그인
    boolean login(String id, String pw) {
        UserInfo user = userMap.get(id);
        if (user == null) {
            System.out.println("아이디가 존재하지 않습니다.");
            return false;
        }
        if (!pw.equals(user.getPw())) {
            System.out.println("비밀번호를 다시 확인해주세요");
            return false;
        }
        System.out.println("로그인에 성공했습니다.");
        System.out.println(user.getId() + "님의 메뉴입니다.");

        userCheck();

        currentLoginUser = user;
        return true;
    }

    //회원 세션확인
    void userCheck() {
        userState = !userState; // 세선변경
        if (!userState) {
            currentLoginUser = null;
        }
    }

    //회원 탈퇴
    boolean userWithdrawal() {
        UserInfo user = currentLoginUser;
        if (user.getBorrowedBookList().size() != 0) {
            System.out.println("대여중인 도서가 있어 회원탈퇴 할 수 없습니다.");
            return false;
        }
        userMap.remove(user.getId());
        userCheck();
        System.out.println("회원 탈퇴 되었습니다.");
        return true;
    }

    //회원 정보 출력
    void printUserInfo() {
        UserInfo user = currentLoginUser;
        System.out.println("ID: " + user.getId());
        System.out.println("PW: " + user.getPw());
        System.out.println("대여중인 도서 목록:");
        
        int book_count = 0;
        for (Book book : user.getBorrowedBookList()) {
            System.out.println("제목 : " + book.getTitle());
            System.out.println("장르 : " + book.getGenre());
            if(book.isBorrowed()){
                System.out.println("대여자 ID : " + book.getBorrowedId());
                System.out.println("대여일 : " + book.getBorrowedDate());
                int lateDays = DateUtils.diffDatesFromToday(book.getBorrowedDate());
                int lateFee = 0;
                if(lateDays >= 7){
                    lateFee = 1000;
                }
                System.out.println("연체료: " + lateFee);
                
            }
            System.out.println("---------------------");
            book_count+=1;
        }
        
        if (book_count == 0) {
        	System.out.println("대여중인 도서가 없습니다.");
        }else {
        	System.out.println("총 " + book_count + "권 대출 중입니다.");
        }
    }

    void save(){
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(USER_FILE));
            for(UserInfo user : userMap.values()){
                bw.write(user.toString());
                bw.newLine();
            }
            System.out.println("회원 정보 저장되었습니다. File: " + USER_FILE.getName());
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}