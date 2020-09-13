package proj.Project1;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class GUI {
    public GUI(ArrayList<BenchmarkSorts.Results> bmsR) {
        System.out.println("GUI: Creating GUI");
        JFrame frame = new JFrame();
        frame.setSize(485, 220);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new FlowLayout());

        JTable table = createTable(bmsR);
        table.setPreferredScrollableViewportSize(new Dimension(470, 160));
        table.setFillsViewportHeight(true);

        JScrollPane scrollPane = new JScrollPane(table);

        panel.add(scrollPane);

        frame.add(panel);
        frame.setVisible(true);

        System.out.println("GUI: Finished creating table");
    }

    private JTable createTable(ArrayList<BenchmarkSorts.Results> r) {
        System.out.println("GUI: Creating table for GUI");
        String[] columnNames = { "Size", "Avg Count", "Ceof Count", "Avg Time", "Coef Time" };

        DefaultTableModel defaultTableModel = new DefaultTableModel(r.size(), columnNames.length);
        defaultTableModel.setColumnIdentifiers(columnNames);

        Object[][] data = new String[r.size()][columnNames.length];

        for (int i = 0; i < r.size(); i++) {
            String[] temp = {
                    r.get(i).getSize(),
                    String.valueOf(r.get(i).getAvgCnt()),
                    String.valueOf(r.get(i).getCoefCnt()),
                    String.valueOf(r.get(i).getAvgTime()),
                    String.valueOf(r.get(i).getCoefTime())
            };
            data[i] = temp;
        }

        return new JTable(data, columnNames);
    }
}
