package forest;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;


/**
 *情報を読取るためのクラス
 *現在不要になりました。
 *@author TOKUUME Shinya
 */
public class Load
{
	/**
	 *ファイルリーダー
	 */
	FileReader aFileReader = null;
	/**
	 *バッファードリーダー
	 */
	BufferedReader aBufferedReader = null;
	/**
	 *読み込むテキストのファイルパス
	 */
	String aFilePath = "./TreeText/tree.txt";
	/**
	 *テキストから読み込んだ文字列
	 */
	List<String> stringLines = new ArrayList<String>();

	/**
	 *コンストラクタ
	 *必要事項の代入
	 */
	public Load(){
		try{
			aFileReader = new FileReader(aFilePath);
			aBufferedReader = new BufferedReader(aFileReader);

			for(;;){
				String aString = aBufferedReader.readLine();
				if(aString != null){
					stringLines.add(aString);
				}else{
					break;
				}
			}
		}catch(FileNotFoundException error){
			error.printStackTrace();
		}catch(IOException error){
			error.printStackTrace();
		}finally{
			try{
				aBufferedReader.close();
				aFileReader.close();
			}catch(IOException error){
				error.printStackTrace();
			}
		}
	}

	/**
	 *テキストファイルからrootの名前のみ取り出し応答
	 *@return roots
	 */
	public ArrayList<String> loadRoot()
	{
		ArrayList<String> roots = new ArrayList<String>();
		for(String aString : stringLines)
		{
			if(aString.matches("^[A-Za-z1-9].*[^:]$"))
			{
				
				roots.add(aString);
			}
			else if(aString.equals("nodes:"))
			{
				break;
			}
		}
		return roots;
	}
	/**
	 *テキストファイルからノードを取り出し応答
	 *エラーを誘発するような書き方のため後日変更する
	 *@return nodes
	 */
	public ArrayList<String> loadNode()
	{
		ArrayList<String> nodes = new ArrayList<String>();
		int startLine = 0;
		for(int lineNumber = 0;;lineNumber++){
			String aString = stringLines.get(lineNumber);
			if(aString.equals("nodes:")){
				startLine = lineNumber+1;
				break;
			}
		}
		for(int lineNumber = startLine;;lineNumber++){
			String aString = stringLines.get(lineNumber);
			if(aString.equals("branches:")){
				break;
			}else{
				nodes.add(aString);
			}
		}
		return nodes;
	}

	/**
	 *テキストファイルからブランチを取り出し応答
	 *エラーを誘発する書き方のため後日変更する
	 *@return branches
	 */
	public ArrayList<String> loadBranch(){
		ArrayList<String> branches = new ArrayList<String>();
		int startLine = 0;
		for(int lineNumber = 0;lineNumber < stringLines.size();lineNumber++){
			String aString = stringLines.get(lineNumber);
			if(aString.equals("branches:")){
				startLine = lineNumber+1;
				break;
			}
		}
		for(int lineNumber = startLine;lineNumber < stringLines.size();lineNumber++){

			String aString = stringLines.get(lineNumber);
			if(aString == null){
				break;
			}else{
				branches.add(aString);
			}
		}
		return branches;
	}
}
