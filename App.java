public class App {
    public static void main(String[] args) throws Exception {
        SegitigaSiku abc = new SegitigaSiku(5.0, 6.0);
        abc.setNama("Segitiga siku-siku");
        abc.getInfo();

        Persegi persegi = new Persegi(4.0);
        persegi.setNama("Persegi");
        persegi.getInfo();
        
        Lingkaran lingkaran = new Lingkaran(3.0);
        lingkaran.setNama("Lingkaran");
        lingkaran.getInfo();

        PersegiPanjang persegiPanjang = new PersegiPanjang(4.0, 5.0);
        persegiPanjang.setNama("Persegi Panjang");
        persegiPanjang.getInfo();

        SegitigaSamaKaki ssk = new SegitigaSamaKaki(4.0, 3.0);
        ssk.setNama("Segitiga Sama Kaki");
        ssk.getInfo();

        SegitigaSamaSisi sss = new SegitigaSamaSisi(4.0);
        sss.setNama("Segitiga Sama Sisi");
        sss.getInfo();

        SegitigaSembarang ssb = new SegitigaSembarang(5.0, 7.0, 4.0);
        ssb.setNama("Segitiga Sembarang");
        ssb.getInfo();
    }
}

class BangunDatar {
    protected double luas;
    protected double keliling;
    protected String nama;

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void getInfo() {
        System.out.println("Nama bangun datar: " + nama);
        System.out.println("Luas: " + luas);
        System.out.println("Keliling: " + keliling);
    }
}

class SegitigaSiku extends Segitiga {
    public SegitigaSiku(Double alas, Double tinggi){
        this.sisi3 = this.getSisiMiring(alas, tinggi);
        super.setProperty(alas, tinggi, this.sisi3);
        super.hitungLuas();
        super.hitungKeliling();
    }

    public double getSisiMiring(Double alas, Double tinggi){
        return Math.sqrt(Math.pow(alas, 2) + Math.pow(tinggi, 2));
    }
}

class Segitiga extends BangunDatar {
    protected Double sisi1;
    protected Double sisi2;
    protected Double sisi3;

    public void setProperty(Double sisi1, Double sisi2, Double sisi3){
        this.sisi1 = sisi1;
        this.sisi2 = sisi2;
        this.sisi3 = sisi3;
    }

    public void hitungLuas(){
        Double s = (sisi1 + sisi2 + sisi3) / 2;
        super.luas = Math.sqrt(s * (s - sisi1) * (s - sisi2) * (s - sisi3));
    }

    public void hitungKeliling(){
        super.keliling = sisi1 + sisi2 + sisi3;
    }
}

class Persegi extends BangunDatar{
    protected Double sisi;
    public Persegi(Double sisi){
        this.sisi = sisi;
        hitungLuas();
        hitungKeliling();
    }

    public void hitungLuas(){
        super.luas = sisi * sisi;
    }

    public void hitungKeliling(){
        super.keliling = 4 * sisi;
    }
}

class Lingkaran extends BangunDatar {
    protected Double jariJari;

    public Lingkaran(Double jariJari) {
        this.jariJari = jariJari;
        hitungLuas();
        hitungKeliling();
    }

    public void hitungLuas() {
        super.luas = Math.PI * jariJari * jariJari;
    }

    public void hitungKeliling() {
        super.keliling = 2 * Math.PI * jariJari;
    }
}

class PersegiPanjang extends BangunDatar {
    protected Double panjang;
    protected Double lebar;

    public PersegiPanjang(Double panjang, Double lebar) {
        this.panjang = panjang;
        this.lebar = lebar;
        hitungLuas();
        hitungKeliling();
    }

    public void hitungLuas() {
        super.luas = panjang * lebar;
    }

    public void hitungKeliling() {
        super.keliling = 2 * (panjang + lebar);
    }
}

class SegitigaSamaKaki extends Segitiga {
    public SegitigaSamaKaki(Double alas, Double tinggi){
        super.setProperty(alas, tinggi, tinggi); // Karena pada segitiga sama kaki, sisi miring = tinggi
        super.hitungLuas();
        super.hitungKeliling();
    }
}

class SegitigaSamaSisi extends Segitiga {
    public SegitigaSamaSisi(Double sisi) {
        super.setProperty(sisi, sisi, sisi); // Segitiga sama sisi memiliki ketiga sisinya sama panjang
        super.hitungLuas();
        super.hitungKeliling();
    }
}

class SegitigaSembarang extends Segitiga {
    public SegitigaSembarang(Double sisi1, Double sisi2, Double sisi3) {
        super.setProperty(sisi1, sisi2, sisi3);
        super.hitungLuas();
        super.hitungKeliling();
    }
}
