package app.models;

public class Membership {
    private final String tier;
    private final String price;
    private final String desc;
    private final boolean featured;

    public Membership(String tier, String price, String desc, boolean featured) {
        this.tier = tier; this.price = price; this.desc = desc; this.featured = featured;
    }
    public String getTier() { return tier; }
    public String getPrice() { return price; }
    public String getDesc() { return desc; }
    public boolean isFeatured() { return featured; }
}