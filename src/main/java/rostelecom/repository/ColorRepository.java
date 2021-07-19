package rostelecom.repository;

import rostelecom.model.ColorItem;
import rostelecom.utils.SqlHelper;
import rostelecom.utils.StaticCollection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ColorRepository implements Repository {
    private final SqlHelper sqlHelper;

    public ColorRepository(String dbUrl, String dbUser, String dbPassword) {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException(e);
        }
        sqlHelper = new SqlHelper(() -> DriverManager.getConnection(dbUrl, dbUser, dbPassword));
    }

    @Override
    public List<ColorItem> getAllSorted() {
        List<ColorItem> items = new ArrayList<>();

        try {
            sqlHelper.transactionalExecute(conn -> {
                try (PreparedStatement ps = conn.prepareStatement("SELECT color_number, name FROM \"TSVETA\" ORDER BY color_number")) {
                    ResultSet rs = ps.executeQuery();
                    while (rs.next()) {
                        items.add(new ColorItem(rs.getString("color_number"), rs.getString("name")));
                    }
                }

                return items;
            });
        } catch (SQLException throwables) {
            // if your database has given up
            StaticCollection.init(items);
        }

        return items;

    }


}
