import java.io.*;
import java.util.*;
public class Solution3 {
    // https://codingcompetitions.withgoogle.com/kickstart/submissions/00000000008cb33e/00000000004bd38a
    private static long fac(int n) {
        long fac=1; for (int i=1; i<=n; i++) fac*=i;
        return fac;
    }
    private static long pow(long n, long k) {
        long p=1; for (int rep=0; rep<k; rep++) p*=n;
        return p;
    }
    private static long subtot(int L, long s0, long p0) {
        //return # of L-length sequences X of digits 0..9
        //  s.t. s0+s==0 or (p0*p) mod (s0+s) == 0,
        //  where s=sum of digits of X, p=product of digits of X
        class DFS {
            int[] hist;
            long dfs_ans;
            void dfs(int d, int dcnt, long s, long p) {
                if (d==10) {
                    if (dcnt==L && (s0+s==0 || (p0*p)%(s0+s)==0)) {
                        long ret=fac(L);
                        for (int d1=1; d1<10; d1++)
                            ret/=fac(hist[d1]);
                        dfs_ans+=ret;
                        //System.out.println(Arrays.toString(hist)+" "+ret);
                    }
                    return;
                }
                for (int amt=0; amt<=L; amt++) {
                    int ncnt=dcnt+amt;
                    if (ncnt<=L) {
                        hist[d]=amt;
                        dfs(d+1,ncnt,s+d*amt,p*pow(d,amt));
                    }
                }
            }
            long ans() {
                hist=new int[10]; Arrays.fill(hist,-1);
                dfs_ans=0;
                dfs(1,0,0,1);
                return dfs_ans;
            }
        }
        if (p0==0) return pow(10,L);
        return new DFS().ans()+(pow(10,L)-pow(9,L));
    }
    private static long tot(long M) {
        //count # interesting natural numbers <M
        String S=""+M;
        int[] digs=new int[S.length()];
        for (int i=0; i<S.length(); i++) digs[i]=S.charAt(i)-'0';
        //search over all numbers with fewer number of digits than M
        long ans=0;
        for (int l=1; l<S.length(); l++)
            for (int d=1; d<10; d++) ans+=l==1?1:subtot(l-1,d,d);
        for (int i=0; i<S.length(); i++) {
            for (int fd=(i==0?1:0); fd<digs[i]; fd++) {
                long s0=0, p0=1;
                for (int j=0; j<i; j++) {
                    int d=digs[j];
                    s0+=d; p0*=d;
                }
                s0+=fd; p0*=fd;
                //we have S.length()-1-i digits left to manipulate
                //they can be any arbitrary sequence X of 0s..9s
                //s.t., where X's digit sum is s and product sum is p,
                //  (p0*p) mod (s0+s) == 0
                //first, only consider X that do not contain a 0
                //we can brute force all possible histograms of digits of X
                int L=S.length()-1-i;
                if (L==0) ans+=s0==0||p0%s0==0?1:0;
                else ans+=subtot(L,s0,p0);
            }
        }
        return ans;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        int T=Integer.parseInt(in.readLine());
        for (int t=1; t<=T; t++) {
            StringTokenizer tok=new StringTokenizer(in.readLine());
            long A=Long.parseLong(tok.nextToken()),
                    B=Long.parseLong(tok.nextToken());
            System.out.printf("Case #%d: %s%n",t,tot(B+1)-tot(A));
        }
        /*int cnt=0;
        for (int i=1; i<10000; i++) {
            String s=""+i;
            long sum=0, prod=1;
            for (int j=0; j<s.length(); j++) {
                int d=s.charAt(j)-'0';
                sum+=d;
                prod*=d;
            }
            if (sum==0||prod%sum==0) cnt++;
            System.out.println((i+1)+" "+cnt+" "+tot(i+1));
        }*/
    }
}