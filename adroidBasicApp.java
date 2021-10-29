@Override public void setUp() throws Exception {
  super.setUp();
  username=TestConstants.USERNAME;
  password=TestConstants.PASSWORD;
  serverUrl=TestConstants.SERVER_URL;
  wikiName=TestConstants.WIKI_NAME;
  spaceName=TestConstants.SPACE_NAME;
  pageName=TestConstants.CREATE_PAGE_NAME + "-" + count;
  attachmentName=TestConstants.ATTACHMENT_NAME;
  objClsName1=TestConstants.OBJECT_CLASS_NAME_1;
  objClsName2=TestConstants.OBJECT_CLASS_NAME_2;
  rm=new XmlRESTFulManager(serverUrl,username,password);
  api=rm.getRestConnector();
  rao=rm.newDocumentRao();
  doc=new Document(wikiName,spaceName,pageName);
  doc.setTitle(pageName);
  api.deletePage(wikiName,spaceName,pageName);
  if (count == 9) {
    Application sys=XWikiApplicationContext.getInstance();
    FileOutputStream fos=sys.openFileOutput(attachmentName,Context.MODE_WORLD_READABLE);
    PrintWriter writer=new PrintWriter(fos);
    writer.println("this is a text attachment.");
    writer.flush();
    writer.close();
    FileInputStream fis=sys.openFileInput(attachmentName);
    byte[] buff=new byte[30];
    int i=0;
    while (i != -1) {
      i=fis.read(buff);
    }
    Log.d(TAG,new String(buff));
    af1=sys.getFileStreamPath(attachmentName);
  }
  Log.d(TAG,"setup test method:" + count);
}
 
