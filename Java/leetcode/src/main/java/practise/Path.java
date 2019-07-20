package practise;

public class Path {
    private String path;

    public Path(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    public void cd(String newPath) {
//        throw new UnsupportedOperationException("Waiting to be implemented.");
        //absolute
        if (newPath.substring(0, 1).equals("/") ){
            this.path = newPath;
        }else{
            //relative
            if (newPath.equals("..") || newPath.equals("../"))  this.path = getLastPath(1);
            else{
                String s1 = getLastPath(countTimes(newPath));
                System.out.println(s1);

                String s2 = newPath.endsWith("/") ? "" :  "/" + newPath.replace("../", "");
                System.out.println(s2);
                this.path = s1 + s2;
            }
        }
    }

    private int countTimes(String input){
        int count = 0;

        String sb = input;
        while (sb.contains("../")){
            sb = sb.replaceFirst("../", "");
            count++;
        }
        return count;
    }

    private String getLastPath(int level){
//        StringBuilder sb = new StringBuilder();
        char[] c = this.path.toCharArray();
        int count = 0;
        String ret = "";
        for (int i = c.length - 1; i >= 0; i--){
            if (c[i] == '/') count++;
            if (count >= level){
                ret = this.path.substring(0, i);
                break;
            }
        }
        return ret;
//        this.path.substring(0, this.path.lastIndexOf("/"));
    }
    public static void main(String[] args) {
        Path path = new Path("/a/b/c/d");
//        path.cd("../x");
//        path.cd("../../x");
//        path.cd("../../");
//        path.cd("../../y/z");
        path.cd("../../../../z");
        System.out.println(path.getPath());
    }
}