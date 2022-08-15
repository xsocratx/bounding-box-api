package com.example.boundigbox.model;
import lombok.*;

@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class BoundingBox {

    private int id;
    private static int nextId = 1;
    private String name;
    private int topLeftPointX;
    private int topLeftPointY;
    private int bottomRightPointX;
    private int bottomRightPointY;

    public BoundingBox(String name, int topLeftPointX, int topLeftPointY, int bottomRightPointX, int bottomRightPointY) {

        this.name = name;
        this.topLeftPointX = topLeftPointX;
        this.topLeftPointY = topLeftPointY;
        this.bottomRightPointX = bottomRightPointX;
        this.bottomRightPointY = bottomRightPointY;
        this.id = nextId;
        nextId++;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void setName(final String name) {
        this.name = name;
    }

    public void setTopLeftPointX(final int topLeftPointX) {
        this.topLeftPointX = topLeftPointX;
    }

    public void setTopLeftPointY(final int topLeftPointY) {
        this.topLeftPointY = topLeftPointY;
    }

    public void setBottomRightPointX(final int bottomRightPointX) {
        this.bottomRightPointX = bottomRightPointX;
    }

    public void setBottomRightPointY(final int bottomRightPointY) {
        this.bottomRightPointY = bottomRightPointY;
    }


}
