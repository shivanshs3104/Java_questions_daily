class Solution {
    public int finalValueAfterOperations(String[] operations) {
        int X = 0;
        for(String op: operations){
            if("X++".equals(op) || "++X".equals(op)){
                X++;
            }
            else{
                X--;
            }
        }
        return X;
    }
}