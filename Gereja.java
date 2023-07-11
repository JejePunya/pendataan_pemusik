import java.util.ArrayList;
import java.util.Iterator;

class Gereja extends Pemusik {
    public ArrayList<Pemusik> pemusik = new ArrayList();
    public ArrayList<Latihan> latihans = new ArrayList();

    Gereja() {
    }

    public void addMember(Pemusik member) {
        if (!this.isMemberIdExist(member.getId())) {
            this.pemusik.add(member);
        } else {
            System.out.println("Pemusik Sudah ada !");
        }

    }

    public boolean isMemberIdExist(int id) {
        Iterator var2 = this.pemusik.iterator();

        Pemusik member;
        do {
            if (!var2.hasNext()) {
                return false;
            }

            member = (Pemusik)var2.next();
        } while(member.getId() != id);

        return true;
    }

    public void addJadwal(Latihan latihan) {
        if (!this.isJadwalIdExist(latihan.id)) {
            this.latihans.add(latihan);
        } else {
            System.out.println("Latihan Id Sudah ada !");
        }

    }

    public boolean isJadwalIdExist(int id) {
        Iterator var2 = this.latihans.iterator();

        Latihan latihan;
        do {
            if (!var2.hasNext()) {
                return false;
            }

            latihan = (Latihan)var2.next();
        } while(latihan.id != id);

        return true;
    }

    public void Jadwal() {
        System.out.println("============================");
        System.out.println("  JADWAL PELAYANAN IBADAH   ");
        System.out.println("============================");
        System.out.println("|Jumat   |   17.00–19.30   |");
        System.out.println("|Sabtu   |   19.30–21.00   |");
        System.out.println("|Minggu  |   08.00–10.00   |");
        System.out.println("============================");
    }
}
