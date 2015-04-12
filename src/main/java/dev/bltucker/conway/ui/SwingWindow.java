package dev.bltucker.conway.ui;

import dev.bltucker.conway.cells.Cell;
import dev.bltucker.conway.cells.State;
import dev.bltucker.conway.grid.GameGrid;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;

public final class SwingWindow extends JFrame implements UserInterface{
    
    JPanel gridPanel = new JPanel();
    JPanel[][] cells;
    
    public SwingWindow(int row, int column){
        super("Conway's Game Of Life");
        setSize(600,600);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        gridPanel.setLayout(new GridLayout(row, column));
        cells = new JPanel[row][column];
        
        for(int i = 0; i < row; i++){
            for(int j = 0; j < column; j++){
                cells[i][j] = new JPanel();
                gridPanel.add(cells[i][j]);
            }
        }
        
        
        add(gridPanel);
        setVisible(true);
    }

    @Override
    public void draw(GameGrid grid) {
        
        for(int i = 0; i < grid.getWidth(); i++){
            for(int j = 0; j < grid.getHeight(); j++){
                
                Cell cell = grid.getCell(i, j);
                
                //0,0 is bottom left in our grid
                //but it is top left in this window.
                
                int transformedY = (grid.getHeight() -1) -j;
                
                if(cell.getState().equals(State.LIVE)){
                    cells[transformedY][i].setBackground(java.awt.Color.GREEN);
                } else {
                    cells[transformedY][i].setBackground(UIManager.getColor ( "Panel.background" ));
                }
                
            }
        }
    
    }

}
