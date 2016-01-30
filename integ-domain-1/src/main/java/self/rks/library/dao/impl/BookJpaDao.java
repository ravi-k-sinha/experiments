package self.rks.library.dao.impl;

import self.rks.dao.JpaDao;
import self.rks.dao.impl.BaseJpaDao;
import self.rks.library.dao.BookDao;
import self.rks.library.domain.Book;

import javax.enterprise.context.Dependent;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@JpaDao
@Dependent
public class BookJpaDao extends BaseJpaDao<Long, Book> implements BookDao {

    public BookJpaDao() {
        super(Book.class);
    }

    @Override
    @PersistenceContext(name = "libraryPU")
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

}
