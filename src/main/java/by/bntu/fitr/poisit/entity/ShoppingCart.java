package by.bntu.fitr.poisit.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ShoppingCart {
    private int accountId;
    private int id;
    private int itemId;
    private Item item;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShoppingCart that = (ShoppingCart) o;
        return accountId == that.accountId && id == that.id && itemId == that.itemId && Objects.equals(item, that.item);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountId, id, itemId, item);
    }
}
