import java.util.Iterator;
import java.util.Scanner;

public class Main {
    static Scanner scan;
    static Gereja gereja;

    public Main() {
    }

    public static void main(String[] args) {
        initGerejaData();

        for(String isContinue = "y"; isContinue.equals("y"); isContinue = scan.next()) {
            showMenu();
            int selectedMenu = chooseMenu();

            try {
                switch (selectedMenu) {
                    case 1:
                        showPemusik();
                        break;
                    case 2:
                        addPemusik();
                        break;
                    case 3:
                        updatePemusik();
                        break;
                    case 4:
                        deletePemusik();
                        break;
                    case 5:
                        addJlatihan();
                        break;
                    case 6:
                        showJlatihan();
                        break;
                    case 7:
                        deleteJlatihan();
                        break;
                    case 8:
                        gudangAlat();
                        break;
                    case 9:
                        jadwalIbadah();
                        break;
                    default:
                        throw new IllegalArgumentException("Input yang anda masukkan salah!");
                }
            } catch (Exception var4) {
                System.out.println("Error: " + var4.getMessage());
            }

            System.out.print("continue ? (y/n)");
        }

    }

    public static void showMenu() {
        System.out.println("====================================");
        System.out.println("||         PENDATAAN GEREJA       ||");
        System.out.println("====================================");
        System.out.println("[1.]       Show List Pemusik      ||");
        System.out.println("[2.]       Tambah Pemusik         ||");
        System.out.println("[3.]       Update Pemusik         ||");
        System.out.println("[4.]       Delete Pemusik         ||");
        System.out.println("[5.]       Add Jadwal Latihan     ||");
        System.out.println("[6.]       Show Jadwal Latihan    ||");
        System.out.println("[7.]       Delete Jadwal Latihan  ||");
        System.out.println("[8.]       Gudang Alat Musik      ||");
        System.out.println("[9.]       Jadwal Ibadah          ||");
        System.out.println("====================================");
    }

    public static void initGerejaData() {
        Pemusik pemain1 = new Pemusik();
        pemain1.setId(1);
        pemain1.setName("Juan (Bassist)");
        Pemusik pemain2 = new Pemusik();
        pemain2.setId(2);
        pemain2.setName("Holyo (Pianist)");
        Pemusik pemain3 = new Pemusik();
        pemain3.setId(3);
        pemain3.setName("Surya (Guitarist)");
        Pemusik pemain4 = new Pemusik();
        pemain4.setId(4);
        pemain4.setName("Ricko (Drummer)");
        Latihan latihan1 = new Latihan();
        latihan1.id = 1;
        latihan1.hari = "Senin";
        latihan1.waktu = "16:00 - 18:00";
        Latihan latihan2 = new Latihan();
        latihan2.id = 2;
        latihan2.hari = "Selasa";
        latihan2.waktu = "19:00 - 20:30";
        Latihan latihan3 = new Latihan();
        latihan3.id = 3;
        latihan3.hari = "Kamis";
        latihan3.waktu= "16:00 - 18:30";
        gereja.pemusik.add(pemain1);
        gereja.pemusik.add(pemain2);
        gereja.pemusik.add(pemain3);
        gereja.pemusik.add(pemain4);
        gereja.latihans.add(latihan1);
        gereja.latihans.add(latihan2);
        gereja.latihans.add(latihan3);
    }

    public static int chooseMenu() {
        System.out.print("choose menu : ");
        int pilihan = scan.nextInt();
        return pilihan;
    }

    public static void showPemusik() {
        int i = 0;
        Iterator var1 = gereja.pemusik.iterator();

        while(var1.hasNext()) {
            Pemusik member = (Pemusik) var1.next();
            ++i;
            System.out.println("" + i + " " + member.getName());
        }

    }

    public static void addPemusik() {
        Pemusik member = new Pemusik();
        System.out.print("id : ");
        int id = scan.nextInt();
        member.setId(id);
        System.out.print("name : ");
        String name = scan.next();
        member.setName(name);
        gereja.addMember(member);
    }

    public static void updatePemusik() {
        System.out.println("Masukkan id member yang ingin di update :");
        int id = scan.nextInt();
        System.out.println("Konfirmasi ID yang ingin di update:");
        int idNew = scan.nextInt();
        boolean idExists = true;
        Iterator var3 = gereja.pemusik.iterator();

        Pemusik memberedit;
        while(var3.hasNext()) {
            memberedit = (Pemusik)var3.next();
            if (memberedit.getId() == idNew) {
                idExists = false;
                break;
            }
        }

        if (idExists) {
            System.out.println("ID tidak sesuai!");
        } else {
            System.out.println("Masukkan Nama Baru :");
            scan.nextLine();
            String nameNew = scan.nextLine();
            memberedit = (Pemusik)gereja.pemusik.get(id - 1);
            memberedit.setId(idNew);
            memberedit.setName(nameNew);
            gereja.pemusik.set(id - 1, memberedit);
        }

    }

    public static void deletePemusik() {
        showPemusik();
        System.out.println("Masukkan id member yang ingin dihapus:");
        int id = scan.nextInt();
        Pemusik memberToDelete = null;
        Iterator var2 = gereja.pemusik.iterator();

        while(var2.hasNext()) {
            Pemusik member = (Pemusik)var2.next();
            if (member.getId() == id) {
                memberToDelete = member;
                break;
            }
        }

        if (memberToDelete != null) {
            gereja.pemusik.remove(memberToDelete);
            System.out.println("Member berhasil dihapus.");
        } else {
            System.out.println("Member dengan ID tersebut tidak ditemukan.");
        }

    }

    public static void addJlatihan() {
        Latihan latihan = new Latihan();
        System.out.print("id : ");
        latihan.id = scan.nextInt();
        System.out.print("Hari : ");
        latihan.hari = scan.next();
        System.out.println("Pukul : ");
        latihan.waktu = scan.next();
        gereja.addJadwal(latihan);
    }

    public static void showJlatihan() {
        int i = 0;
        Iterator var1 = gereja.latihans.iterator();

        while(var1.hasNext()) {
            Latihan latihan = (Latihan)var1.next();
            ++i;
            System.out.println("" + i + ". " + latihan.hari);
            System.out.println(latihan.waktu);
        }

    }

    public static void deleteJlatihan() {
        showJlatihan();
        System.out.println("Masukkan id jadwal yang ingin dihapus :");
        int id = scan.nextInt();
        int index = -1;

        for(int i = gereja.latihans.size() - 1; i >= 0; --i) {
            Latihan latihan = (Latihan)gereja.latihans.get(i);
            if (latihan.id == id) {
                index = i;
                break;
            }
        }

        if (index != -1) {
            gereja.latihans.remove(index);
            System.out.println("Jadwal berhasil dihapus.");
        } else {
            System.out.println("Jadwal dengan ID tersebut tidak ditemukan.");
        }

    }

    public static void gudangAlat() {
        Gudanginstrument Amusik1 = new AlatMusik("Gitar",2 );
        Gudanginstrument Amusik2 = new AlatMusik("Bass",1);
        System.out.println("Alat Musik 1 :");
        System.out.println("Jenis :" + Amusik1.name);
        System.out.println("Status: " + Amusik1.Jumlahalat + " Qty");
        Amusik1.statusBarang();
        System.out.println("------------------------------------------");
        System.out.println("Alat Musik 2 :");
        System.out.println("Jenis :" + Amusik2.name);
        System.out.println("Jumlah :" + Amusik2.Jumlahalat + " Qty");
        Amusik2.statusBarang();
    }

    public static void jadwalIbadah() {
        Gereja jadwal1 = new Gereja();
        jadwal1.Jadwal();
    }

    static {
        scan = new Scanner(System.in);
        gereja = new Gereja();
    }
}
