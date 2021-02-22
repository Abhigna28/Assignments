private int process(String text, List<String> words) {
  int spaces = 0;
  
  for (int i=0; i<text.length(); ) {
    if (text.charAt(i) == ' ') {
      while (i < text.length() && text.charAt(i) == ' ') {
        spaces ++;
        i++;
      }
    }
    else {
      StringBuilder sb = new StringBuilder();
      while (i < text.length() && text.charAt(i) != ' ') {
        sb.append(text.charAt(i));
        i++;
      }
      if (sb.length() > 0) {
        words.add(sb.toString());
      }
    }
  }
  
  return spaces;
}

public String reorderSpaces(String text) {
  List<String> words = new ArrayList<String>();
  int spaces = this.process(text, words);
  
  int divider = (words.size() - 1) > 0 ? (words.size() - 1) : 1;
  
  int targetSpaces = spaces / divider;
  int remainingSpaces = spaces % divider;
  if (words.size()<= 1) {
    remainingSpaces += targetSpaces;
  }
  
  StringBuilder sb = new StringBuilder();
  if (words.size() > 0) {
    sb.append(words.get(0));
  }
  for (int i=1; i<words.size(); i++) {
    for (int j=0; j<targetSpaces; j++) {
      sb.append(" ");
    }
    sb.append(words.get(i));
  }
  
  if (remainingSpaces > 0) {
    for (int j=0; j<remainingSpaces; j++) {
      sb.append(" ");
    }
  }
  
  return sb.toString();
}