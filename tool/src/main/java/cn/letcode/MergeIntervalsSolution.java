package cn.letcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MergeIntervalsSolution {
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> resultList = new ArrayList<>();
        if (intervals.size() == 0) {
            return resultList;
        }
        intervals.forEach(val->{
            System.out.println(val.start);
        });
        intervals.sort(new java.util.Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                if(o1.start<o2.start){
                    return -1;
                }
                if(o1==o2||o1.start==o2.start) {
                    return 0;
                }
                return 1;
            }
        });
        intervals.forEach(val->{
            System.out.println(val.start);
        });
        Interval node = intervals.get(0);
        for (int i = 1; i < intervals.size(); i++) {
            Interval tempNode = intervals.get(i);
            if(node.end>=tempNode.start) {
                if (node.start > tempNode.start) {
                    node.start = tempNode.start;
                }
                if (node.end < tempNode.end) {
                    node.end = tempNode.end;
                }
            }else{
                resultList.add(node);
                node = tempNode;
            }
        }
        resultList.add(node);
        return resultList;
    }

    public static void main(String[] args) {
        List<Interval> merge = new MergeIntervalsSolution().merge(new ArrayList<Interval>() {
            {
                //add(new Interval(3, 4));
                //add(new Interval(0, 2));
                add(new Interval(1, 3));
                add(new Interval(2, 6));
                add(new Interval(8, 10));
                add(new Interval(15, 18));
            }
        });
        for (Interval val : merge) {
            System.out.print(val.start + ",");
            System.out.print(val.end + "\t");
        }
    }
}

class Interval {
    int start;
    int end;
    Interval() {
        start = 0;
        end = 0;
    }
    Interval(int s, int e) {
        start = s;
        end = e;
    }
}


