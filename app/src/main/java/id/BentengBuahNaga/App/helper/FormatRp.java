package id.BentengBuahNaga.App.helper;

public class FormatRp {
    public static String FormatRp(String rupiah) {

        String format = "Rp." + String.format("%,.0f",Double.parseDouble(rupiah));
        return format;
    }
}
