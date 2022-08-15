package com.example.boundigbox.repository;

import com.example.boundigbox.model.BoundingBox;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Repository
@Slf4j
public class BoundingBoxRepository {

    @Autowired
    private Environment env;

    public String getImageWidth(){
        return env.getProperty("workspace.image.width");
    }

    public String getImageHeight(){
        return env.getProperty("workspace.image.height");
    }

    public String getMinWidth(){
        return env.getProperty("workspace.boundingBox.minWidth");
    }

    public String getMinHeight(){
        return env.getProperty("workspace.boundingBox.minHeight");
    }

    private List<BoundingBox> list = new ArrayList<BoundingBox>(Arrays.asList(
            new BoundingBox(1,"Point_1", 1, 1, 1,1 ),
            new BoundingBox(2,"Point_2", -1, 0, 0, -1),
            new BoundingBox(3,"Point_3", 0, -1, 1, 0),
            new BoundingBox(4,"Point_4", 0,0,1,-1)));

    public List<BoundingBox> getAllBoundingBox() {
        return list;
    }

    public BoundingBox findById(int id) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == (id)) {
                return list.get(i);
            }
        }
        return null;
    }

    public List<BoundingBox> search(String name) {
        return list.stream().filter(x -> x.getName().startsWith(name)).collect(Collectors.toList());
    }

    public BoundingBox save(BoundingBox bb){
        if (validationCoordinate(bb)) {
            int id = list.size() + 1;
            BoundingBox boundingBox = new BoundingBox();
            boundingBox.setId(id);
            boundingBox.setName(bb.getName());
            boundingBox.setTopLeftPointX(bb.getTopLeftPointX());
            boundingBox.setTopLeftPointY(bb.getTopLeftPointY());
            boundingBox.setBottomRightPointX(bb.getBottomRightPointX());
            boundingBox.setBottomRightPointY(bb.getBottomRightPointY());
            list.add(boundingBox);

            return boundingBox;
        }
        return null;
    }

    public String delete(int id) {
        list.removeIf(x -> x.getId() == (id));
        return null;
    }

    public BoundingBox update(int id, BoundingBox bb) {

        if(validationCoordinate(bb)) {

            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getId() == id) {

                    BoundingBox boundingBox = new BoundingBox();
                    boundingBox.setId(id);
                    boundingBox.setName(bb.getName());
                    boundingBox.setTopLeftPointX(bb.getTopLeftPointX());
                    boundingBox.setTopLeftPointY(bb.getTopLeftPointY());
                    boundingBox.setBottomRightPointX(bb.getBottomRightPointX());
                    boundingBox.setBottomRightPointY(bb.getBottomRightPointY());

                    list.set(i, boundingBox);

                    return boundingBox;
                }
            }

            BoundingBox boundingBox = new BoundingBox();
            boundingBox.setId(id);
            boundingBox.setName(bb.getName());
            boundingBox.setTopLeftPointX(bb.getTopLeftPointX());
            boundingBox.setTopLeftPointY(bb.getTopLeftPointY());
            boundingBox.setBottomRightPointX(bb.getBottomRightPointX());
            boundingBox.setBottomRightPointY(bb.getBottomRightPointY());

            list.add(boundingBox);
            return boundingBox;
        }
        return null;
    }

    public boolean validationCoordinate (BoundingBox bb) {

        int topLeftPointX = bb.getTopLeftPointX();
        int topLeftPointY = bb.getTopLeftPointY();
        int bottomRightPointX = bb.getBottomRightPointX();
        int bottomRightPointY = bb.getBottomRightPointY();

        int imageWidth = Integer.parseInt(getImageWidth());
        int imageHeight = Integer.parseInt(getImageHeight());
        int minWidth = Integer.parseInt(getMinWidth());
        int minHeight = Integer.parseInt(getMinHeight());

        if (topLeftPointX >= 0 && topLeftPointX <= imageWidth
                && bottomRightPointX >= 0 && bottomRightPointX <= imageWidth){
            if(topLeftPointY >= 0 && topLeftPointY <= imageHeight
                    && bottomRightPointY >= 0 && bottomRightPointY <=imageHeight){
                if((bottomRightPointX - topLeftPointX) > minWidth &&
                        (bottomRightPointY - topLeftPointY) > minHeight){
                    return true;
                }
            }
        }
        return false;
    }

}
















