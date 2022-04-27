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
public class Purchase {
    private int purchaseId;
    private int accountId;
    private int itemId;
    private Item item;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Purchase purchase = (Purchase) o;
        return purchaseId == purchase.purchaseId && accountId == purchase.accountId && itemId == purchase.itemId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(purchaseId, accountId, itemId);
    }
}
