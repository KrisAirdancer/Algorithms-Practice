class SubrectangleQueries
{
    private int[][] rectangle;
    
    public SubrectangleQueries(int[][] rectangle)
    {
        this.rectangle = rectangle;
    }
    
    public void updateSubrectangle(int row1, int col1, int row2, int col2, int newValue)
    {
        // System.out.println("AT: updateSubrectangle()");
        for (int col = col1; col <= col2; col++)
        {            
            for (int row = row1; row <= row2; row++)
            {
                // System.out.println("(col, row): (" + col + ", " + row + "), value:" + this.rectangle[row][col]);
                rectangle[row][col] = newValue;
            }
        }
    }
    
    public int getValue(int row, int col)
    {
        return rectangle[row][col];
    }
}

/**
 * Your SubrectangleQueries object will be instantiated and called as such:
 * SubrectangleQueries obj = new SubrectangleQueries(rectangle);
 * obj.updateSubrectangle(row1,col1,row2,col2,newValue);
 * int param_2 = obj.getValue(row,col);
 */