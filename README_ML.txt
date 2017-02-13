Steps to run ML code:
1. Upload train file on hdfs 
3. Download categ.scala file
2. Modify location of file in scala code:
	 val reviewdata = sc.textFile("hdfs:/cshadoop1/user/<location of file>");
4. Run: spark-shell -i categ.scala
Output prediction is displayed on console

Steps to run tweet downloader:
hadoop jar JavaHDFS-0.0.1-SNAPSHOT-jar-with-dependencies.jar JavaHDFS.JavaHDFS.TweetDownloader <localdirectory>/tweets hdfs://cshadoop1/user/<new folder location>

hadoop jar JavaHDFS-0.0.1-SNAPSHOT-jar-with-dependencies.jar JavaHDFS.JavaHDFS.TweetDownloader /home/013/s/sx/sxs159231/shaktifiles/proj/tweetfiles_Aug5/tweets hdfs://cshadoop1/user/sxs159231/project/tweetdata_Aug5