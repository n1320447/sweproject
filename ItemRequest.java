// Association class between Library and LibraryCard
 public class ItemRequest {
    public LibraryCard card;
    public Item item;

    ItemRequest(LibraryCard newCard, Item newItem) {
        card = newCard;
        item = newItem;
    }


}
