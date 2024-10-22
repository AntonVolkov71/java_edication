package src.main.java.volk.httpServer;

import java.time.LocalDate;

public class UserPost {
    // URL-адрес, по которому можно скачать фото
    private String photoUrl;

    // Дата публикации
    private LocalDate publicationDate;

    // Уникальный идентификатор автора поста
    private int userId;
    // Текстовой комментарий к фото
    private String description;
    // Сколько людей поставило лайк этому посту
    private int likesQuantity;

    public LocalDate getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(LocalDate publicationDate) {
        this.publicationDate = publicationDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getLikesQuantity() {
        return likesQuantity;
    }

    public void setLikesQuantity(int likesQuantity) {
        this.likesQuantity = likesQuantity;
    }

    // Геттеры и сеттеры для обращения к данным:
    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
