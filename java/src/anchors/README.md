#AnchorTextAndStatistics
<br>
<br>For more informatian, please visit: http://vi.ikt.ui.sav.sk/User:Filip.Blanarik?view=home
<br>
<br>You can specify a source file in the graphic interface 
<br>however it shoul be XML dump from english version of wikipedia
<br>
<br>For calculate statistics on huge files use parameter -Xmx4096  (>>4096)
<br>
<br>For unit test you will need following files:
<br>    Root->data->sample_anchor_extraction_test.txt
<br>	Root->data->sample_df_cf_test
<br>    Root->data->sample_input_enwiki-pages-articles-123.xml 
<br>Test DF_CF_count_test expected parsed sample_input_enwiki-pages-articles-123.xml in 
<br>	program_output_anchor.txt
<br>
<br>Program structure
<br>src->
<br>	 Anchor.java
<br>	 File_with_anchor_txt.java
<br>	 Frequencies.java
<br>	 GraphicInterface.form
<br>	 GraphicInterface.java
<br>	 Page.java
<br>	 Parse_XML_wiki.java
<br>	 Statistics.java
<br>	 Wiki_main.java
<br>test->
<br>	 Anchor_extraction_test.java
<br>	 DF_CF_count_test.java	
<br>data->
<br>	 sample_anchor_extraction_test.txt
<br>	 sample_df_cf_test
<br>	 sample_input_enwiki-pages-articles-123.xml 

