import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ExpenseDAO dao = new ExpenseDAO();

        while (true) {

            System.out.println("\n===== STUDENT EXPENSE TRACKER =====");
            System.out.println("1. Add Expense");
            System.out.println("2. View Expenses");
            System.out.println("3. Delete Expense");
            System.out.println("4. Update Expense");
            System.out.println("5. Search Expense");
            System.out.println("6. Total Spending");
            System.out.println("7. Category Summary");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");

            int choice;

            try {
            choice = sc.nextInt();
            sc.nextLine();
            } catch (Exception e) {
            System.out.println("Please enter a valid number!");
            sc.nextLine();
            continue;
            }

            switch (choice) {

                case 1:
                    System.out.print("Enter category: ");
                    String category = sc.nextLine();

                    if (category.trim().isEmpty()) {
                        System.out.println("Category cannot be empty!");
                        continue;
                    }

                    System.out.print("Enter amount: ");
                    double amount;

                    try {
                        amount = sc.nextDouble();
                        sc.nextLine();

                        if (amount <= 0) {
                            System.out.println("Amount must be greater than 0!");
                            continue;
                        }

                    } catch (Exception e) {
                        System.out.println("Please enter a valid amount!");
                        sc.nextLine();
                        continue;
                    }

                    System.out.print("Enter date (YYYY-MM-DD): ");
                    String date = sc.nextLine();

                    if (!date.matches("\\d{4}-\\d{2}-\\d{2}")) {
                        System.out.println("Invalid date format! Use YYYY-MM-DD.");
                        continue;
                    }

                    System.out.print("Enter description: ");
                    String description = sc.nextLine();

                    Expense expense = new Expense(
                        0,
                        category,
                        amount,
                        date,
                        description
                    );

                    dao.addExpense(expense);
                    break;

                case 2:
                    dao.viewExpenses();
                    break;

                case 3:
                    System.out.print("Enter expense ID to delete: ");
                    int deleteId = sc.nextInt();

                    dao.deleteExpense(deleteId);
                    break;

                case 4:
                    System.out.print("Enter expense ID to update: ");
                    int updateId = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter new category: ");
                    String newCategory = sc.nextLine();

                    System.out.print("Enter new amount: ");
                    double newAmount = sc.nextDouble();
                    sc.nextLine();

                    System.out.print("Enter new date (YYYY-MM-DD): ");
                    String newDate = sc.nextLine();

                    System.out.print("Enter new description: ");
                    String newDescription = sc.nextLine();

                    dao.updateExpense(
                        updateId,
                        newCategory,
                        newAmount,
                        newDate,
                        newDescription
                    );
                    break;

                case 5:
                    System.out.print("Enter category to search: ");
                    String searchCategory = sc.nextLine();

                    dao.searchExpense(searchCategory);
                    break;

                case 6:
                    dao.showTotalSpending();
                    break;

                case 7:
                    dao.showCategorySummary();
                    break;

                case 8:
                    System.out.println("Thank you for using Student Expense Tracker!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}