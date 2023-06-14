import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MarineManagement {
    public static void main(String[] args) {
        List<Marine> marineList = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("원하는 작업을 선택하세요:");
            System.out.println("1. 새로운 유닛 생성");
            System.out.println("2. 생성된 유닛 목록 확인");
            System.out.println("0. 종료");

            int userChoice = scanner.nextInt();

            switch (userChoice) {
                case 1:
                    System.out.println("새로운 유닛을 생성합니다.");
                    Marine marine = new Marine();
                    marineList.add(marine);
                    marine.start();
                    break;
                case 2:
                    System.out.println("생성된 유닛 목록:");
                    for (Marine marine1 : marineList) {
                        System.out.println("ID: " + marine1.getId() + ", 생성 중: " + marine1.isCreating() + ", 생성 완료: " + marine1.isComplete());
                    }
                    break;
                case 0:
                    System.out.println("프로그램을 종료합니다.");
                    // 모든 쓰레드 중지 처리
                    for (Marine marine1 : marineList) {
                        marine1.stopThread();
                    }
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("잘못된 선택입니다. 다시 선택하세요.");
            }
        }
    }
}

class Marine extends Thread {
    private static int count = 0;
    private int id;
    private volatile boolean creating;
    private volatile boolean complete;

    public Marine() {
        this.id = count++;
        this.creating = true;
        this.complete = false;
    }

    public long getId() {
        return id;
    }

    public boolean isCreating() {
        return creating;
    }

    public boolean isComplete() {
        return complete;
    }

    public void stopThread() {
        complete = true;
        interrupt();
    }

    @Override
    public void run() {
        try {
            // 생성 작업 수행
            System.out.println("ID: " + id + ", 유닛 생성 중...");
            Thread.sleep(10000);
            System.out.println("ID: " + id + ", 유닛 생성");
            creating = false;
            complete = true;
        } catch (InterruptedException e) {
            System.out.println("ID: " + id + ", 유닛 생성 취소");
        }
    }
}