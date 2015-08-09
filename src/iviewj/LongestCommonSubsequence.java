package iviewj;

    public class LongestCommonSubsequence extends TestBase
    {
    public LongestCommonSubsequence(IVerifier v)
    {
      super(v);
    }
    
        public int makeTable(char[] a, char[] b, int[][] table) {
            // table = new int[a.length + 1][b.length + 1];
            for (int j = b.length - 1; j >= 0; j--) {
                for (int i = a.length - 1; i >= 0; i--) {
                    if (a[i] == b[j]) {
                        table[i][j] = 1 + table[i + 1][j + 1];
                    } else {
                        table[i][j] = Math.max(table[i][j + 1], table[i + 1][j]);
                    }
                }
            }
            return table[0][0];
        }

        public void printTable(char[] a, char[] b, int[][] t) {
            w(" " + new String(a));
            for (int j = 0; j < b.length; j++) {
                StringBuilder sb = new StringBuilder();
                sb.append(b[j]);
                for (int i = 0; i < a.length; i++) {
                    sb.append(t[i][j]);
                }
                w(sb.toString());
            }
        }

        public String GetSequence(char[] a, char[] b, int[][] table) {
            StringBuilder seq = new StringBuilder();
            int i = 0;
            int j = 0;
            while (i < a.length && j < b.length) {
                if (a[i] == b[j]) {
                    seq.append(a[i]);
                    i++;
                    j++;
                } else if (table[i + 1][j] > table[i][j + 1]) {
                    i++;
                } else {
                    j++;
                }
            }
            return seq.toString();
        }

        public int LCS(char[] a, char[] b, /* out */ String []subseq) {
            // maybe duplicate declaration
            int[][] table = new int[a.length + 1][b.length + 1];
            int longest = makeTable(a, b, table);
//			printTable(a,b,table);
            subseq[0] = GetSequence(a, b, table);
            return longest;
        }

        public int LCSr(char []a, char []b, int aoff, int boff, /*out*/ String[] subseq)
        {
            int longest;
            String []subProbStr = new String[1];
            String []subProbStr2 = new String[1];

            subseq[0] = "@";
            if (aoff > a.length - 1)
                return 0;
            if (boff > b.length - 1)
                return 0;
            if (a[aoff] == b[boff])
            {
                longest = 1 + LCSr(a, b, aoff + 1, boff + 1, /* out */ subProbStr);
                subseq[0] = a[aoff] + subProbStr[0];
                return longest;
            }
            else
            {
                int subProb1 = LCSr(a, b, aoff + 1, boff, /* out */ subProbStr);
                int subProb2 = LCSr(a, b, aoff, boff + 1, /* out */ subProbStr2);
                if (subProb1 > subProb2)
                {
                    subseq = subProbStr;
                    return subProb1;
                }
                else
                {
                    subseq = subProbStr2;
                    return subProb2;
                }
            }
        }

        public void TestInput(String a, String b, int expect)
        {
            w("Input: (" + a + ") (" + b + ")");
            String []subseq = new String[1];;
            int dist = LCS(a.toCharArray(), b.toCharArray(), /* out */subseq);
            w("Subsequence =" + subseq[0]);
            Verify("Subsequence Length:", expect, dist);
        }

        public void Test1()
        {
            TestInput("cat", "cat", 3);
            TestInput("cat", "ceat", 3);
            TestInput("forest", "for rest", 6);
            TestInput("for rest", "forest", 6);
        }
    }
