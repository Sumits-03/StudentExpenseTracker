import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ExpenseDAO {

    // ADD
    public void addExpense(Expense expense) {
        String sql = "INSERT INTO expenses (category, amount, date, description) VALUES (?, ?, ?, ?)";

        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, expense.getCategory());
            ps.setDouble(2, expense.getAmount());
            ps.setString(3, expense.getDate());
            ps.setString(4, expense.getDescription());

            ps.executeUpdate();

            System.out.println("Expense saved to database!");

            ps.close();
            con.close();

        } catch (Exception e) {
            System.out.println("Failed to save expense!");
            e.printStackTrace();
        }
    }

    // VIEW
    public void viewExpenses() {
        String sql = "SELECT * FROM expenses";

        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println(
                    rs.getInt("id") + " | " +
                    rs.getString("category") + " | ₹" +
                    rs.getDouble("amount") + " | " +
                    rs.getDate("date") + " | " +
                    rs.getString("description")
                );
            }

            rs.close();
            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // DELETE
    public void deleteExpense(int id) {
        String sql = "DELETE FROM expenses WHERE id = ?";

        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, id);

            int rows = ps.executeUpdate();

            if (rows > 0)
                System.out.println("Expense deleted!");
            else
                System.out.println("Expense not found!");

            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // UPDATE
    public void updateExpense(int id, String category, double amount,
                              String date, String description) {

        String sql = "UPDATE expenses SET category=?, amount=?, date=?, description=? WHERE id=?";

        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, category);
            ps.setDouble(2, amount);
            ps.setString(3, date);
            ps.setString(4, description);
            ps.setInt(5, id);

            int rows = ps.executeUpdate();

            if (rows > 0)
                System.out.println("Expense updated!");
            else
                System.out.println("Expense not found!");

            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // SEARCH
    public void searchExpense(String category) {
        String sql = "SELECT * FROM expenses WHERE category = ?";

        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, category);

            ResultSet rs = ps.executeQuery();

            boolean found = false;

            while (rs.next()) {
                found = true;

                System.out.println(
                    rs.getInt("id") + " | " +
                    rs.getString("category") + " | ₹" +
                    rs.getDouble("amount") + " | " +
                    rs.getDate("date") + " | " +
                    rs.getString("description")
                );
            }

            if (!found)
                System.out.println("No expenses found!");

            rs.close();
            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // TOTAL
    public void showTotalSpending() {
        String sql = "SELECT SUM(amount) AS total FROM expenses";

        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                System.out.println("Total Spending: ₹" + rs.getDouble("total"));
            }

            rs.close();
            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // CATEGORY SUMMARY
// CATEGORY SUMMARY
    public void showCategorySummary() {
    String sql = "SELECT category, SUM(amount) AS total FROM expenses GROUP BY category";

    try {
        Connection con = DBConnection.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        System.out.println("\n===== CATEGORY SUMMARY =====");

        while (rs.next()) {
            System.out.println(
                rs.getString("category") +
                " : ₹" +
                rs.getDouble("total")
            );
        }

        rs.close();
        ps.close();
        con.close();

    } catch (Exception e) {
        e.printStackTrace();
    }
}

}