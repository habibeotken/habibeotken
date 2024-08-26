import java.util.Scanner;

public abstract class Aday {
    private int turkce;
    private int matematik;
    private int edebiyat;
    private int fizik;
    private String isim;

    public Aday(int edebiyat,int turkce,int matematik,int fizik,String isim) {
        this.edebiyat = edebiyat;
        this.turkce=turkce;
        this.fizik=fizik;
        this.matematik=matematik;
        this.isim=isim;
    }

    public int getTurkce() {
        return turkce;
    }

    public void setTurkce(int turkce) {
        this.turkce = turkce;
    }

    public int getMatematik() {
        return matematik;
    }

    public void setMatematik(int matematik) {
        this.matematik = matematik;
    }

    public int getFizik() {
        return fizik;
    }

    public void setFizik(int fizik) {
        this.fizik = fizik;
    }

    public int getEdebiyat() {
        return edebiyat;
    }

    public void setEdebiyat(int edebiyat) {
        this.edebiyat = edebiyat;
    }
    abstract int puanHesapla();

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }
}
      class EsitAgirlik extends Aday {
         public EsitAgirlik(int edebiyat, int turkce, int matematik, int fizik, String isim) {
             super(edebiyat, turkce, matematik, fizik, isim);
         }

         @Override
         int puanHesapla() {
             return getEdebiyat() * 4 + getTurkce() * 5 + getFizik() * 1 + getMatematik() * 1;
         }
     }
    class Sayisal extends Aday {
        public Sayisal(int edebiyat, int turkce, int matematik, int fizik,String isim) {
            super(edebiyat, turkce, matematik, fizik,isim);
        }

        @Override
        int puanHesapla() {
            return getEdebiyat()*5+getMatematik()*5+getFizik()*5+getTurkce()*1;
        }
    }
     class Main {
        public static void main(String[] args) {System.out.println("YGS-LYS birinci bulma. ");
            Scanner scn = new Scanner(System.in);
            System.out.println("--------------------------");
            String islemler = "Islemler.....\n"
                    + "1. Esit agırlık birincisi\n"
                    + "2. Sayısal birincisi\n"
                    + "Cıkıs :X";
            System.out.println("--------------------------");

            System.out.println(islemler);


            while (true) {

                System.out.println("Öğrencinin ismi: ");
                String isim1 = scn.next();
                System.out.println("Netleri:(e,t,f,m) ");
                int edebiyat1 = scn.nextInt();
                int turkce1 = scn.nextInt();
                int fizik1 = scn.nextInt();
                int matematik1 = scn.nextInt();
                System.out.println("------------------------");
                System.out.println("Öğrencinin ismi: ");
                String isim2 = scn.next();
                System.out.println("Netleri:(e,t,f,m) ");
                int edebiyat2 = scn.nextInt();
                int matematik2 = scn.nextInt();
                int fizik2 = scn.nextInt();
                int turkce2 = scn.nextInt();

                System.out.println("--------------------------");
                System.out.println("İslemi giriniz.");
                String islem = scn.next();


                if (islem.equals("1")) {
                    EsitAgirlik ea1 = new EsitAgirlik(edebiyat1, turkce1, matematik1, fizik1, isim1);
                    EsitAgirlik ea2 = new EsitAgirlik(edebiyat2, turkce2, matematik2, fizik2, isim2);
                    EsitAgirlik birinci = birinci(ea1, ea2);
                    System.out.println("ea1'in puanı: "+ea1.puanHesapla());
                    System.out.println("ea2'nin puanı: "+ea2.puanHesapla());

                    System.out.println("eşit ağırlık birincisi: " + birinci.getIsim());
                    continue;

                }
                if (islem.equals("2")) {
                    Sayisal say1 = new Sayisal(edebiyat1, turkce1, matematik1, fizik1, isim1);
                    Sayisal say2 = new Sayisal(edebiyat2, turkce2, matematik2, fizik2, isim2);
                    Sayisal birinci = birinci(say1, say2);
                    System.out.println("say1 puanı: "+say1.puanHesapla());
                    System.out.println("say2 puanı: "+say2.puanHesapla());
                    System.out.println("sayısal birincisi: " + birinci.getIsim());

                }
                if (islem.equals("X")) {
                    System.out.println("sistemden cikis yapiliyor..");
                    break;
                }
            }


        }


        public static <E extends Aday > E birinci(E say, E say2) {
            if (say2.puanHesapla() > say.puanHesapla()) {
                return say2;
            }
            if (say.puanHesapla() > say2.puanHesapla()) {
                return say;
            }
            return birinci(say, say2);
        }

        public static<E > void yazdir (E[]dizi){
            for (E e : dizi) {
                System.out.println(e);
            }
        }
    }
