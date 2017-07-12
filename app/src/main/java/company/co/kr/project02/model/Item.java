package company.co.kr.project02.model;

/**
 * Created by Dongjin on 2017. 7. 11..
 */

public class Item {
    int imgSrc;
    String title;
    String content;
    boolean check;

    public Item(int imgSrc, String title, String content, boolean check) {
        this.imgSrc = imgSrc;
        this.title = title;
        this.content = content;
        this.check = check;
    }

    public int getImgSrc() {
        return imgSrc;
    }

    public void setImgSrc(int imgSrc) {
        this.imgSrc = imgSrc;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isCheck() {
        return check;
    }

    public void setCheck(boolean check) {
        this.check = check;
    }

    @Override
    public String toString() {
        return "Item{" +
                "imgSrc=" + imgSrc +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", check=" + check +
                '}';
    }
}
