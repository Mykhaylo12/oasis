package mate.academy.internetshop.service.dao;

import mate.academy.internetshop.dao.ItemDao;
import mate.academy.internetshop.dao.Storage;
import mate.academy.internetshop.lib.Inject;
import mate.academy.internetshop.lib.Service;
import mate.academy.internetshop.model.Item;
import mate.academy.internetshop.service.ItemService;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ItemServiceImpl implements ItemService {
    @Inject
    private static ItemDao itemDao;

    @Override
    public Item create(Item item) {
        return itemDao.create(item);
    }

    @Override
    public Item get(Long id) {
        if (itemDao.get(id).isPresent()) {
            return itemDao.get(id).get();
        } else {
            throw new NoSuchElementException();
        }
    }

    @Override
    public Item update(Item item) {
        return itemDao.update(item);
    }

    @Override
    public void deleteById(Long id) {
        itemDao.deleteById(id);
    }

    @Override
    public void delete(Item item) {
        itemDao.delete(item);
    }

    @Override
    public List<Item> getAll() {
        return Storage.items;
    }
}
