package cn.ccs.bloomfilter;

import com.google.common.base.Charsets;
import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnel;
import com.google.common.hash.PrimitiveSink;

public class Mybloom {
    private static final BloomFilter<String> dealIdBloomFilter = BloomFilter.create(new Funnel<String>() {

        private static final long serialVersionUID = 1L;

        @Override
        public void funnel(String arg0, PrimitiveSink arg1) {

            arg1.putString(arg0, Charsets.UTF_8);
        }

    }, 1024*1024*32);

    public static void main(String[] args) {
        boolean b1 = dealIdBloomFilter.put("dsaffffffff");
        boolean b2 = Mybloom.dealIdBloomFilter.put("dealIdBloomFilter");
        boolean b3 = Mybloom.dealIdBloomFilter.put("dealIdBloomFilter");
        System.out.println(b1);
        System.out.println(b2);
        System.out.println(b3);

    }
}
