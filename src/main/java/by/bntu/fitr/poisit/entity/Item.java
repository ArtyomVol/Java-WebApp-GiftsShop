package by.bntu.fitr.poisit.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Item {
    private int itemId;
    private String name;
    private String description;
    private int cost;
    private String imageLink;
    private int categoryId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return itemId == item.itemId && cost == item.cost && categoryId == item.categoryId && name.equals(item.name) && description.equals(item.description) && imageLink.equals(item.imageLink);
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemId, name, description, cost, imageLink, categoryId);
    }
}
