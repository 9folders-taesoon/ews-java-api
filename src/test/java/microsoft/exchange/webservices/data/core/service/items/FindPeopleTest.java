package microsoft.exchange.webservices.data.core.service.items;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import microsoft.exchange.webservices.base.BaseTest;
import microsoft.exchange.webservices.data.core.enumeration.property.WellKnownFolderName;
import microsoft.exchange.webservices.data.misc.people.IndexedPageItemView;
import microsoft.exchange.webservices.data.property.complex.FolderId;

@RunWith(JUnit4.class)
public class FindPeopleTest extends BaseTest {
    @Test
    public void testFindPeople() throws Exception {
        FolderId folderId = new FolderId(WellKnownFolderName.Directory);
        IndexedPageItemView itemPage = new IndexedPageItemView(20);
        exchangeServiceMock.findPeople(itemPage, folderId);
    }
}
