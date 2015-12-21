package sushi_delivery.kolyadko_polovtseva.com.sushidelivery.entity;

/**
 * Created by User on 21.12.2015.
 */
public class DownloadPictureTaskBean {
    private Integer imageViewId;
    private String imageUrl;

    public DownloadPictureTaskBean(Integer imageViewId, String imageUrl) {
        this.imageViewId = imageViewId;
        this.imageUrl = imageUrl;
    }

    public Integer getImageViewId() {
        return imageViewId;
    }

    public void setImageViewId(Integer imageViewId) {
        this.imageViewId = imageViewId;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
