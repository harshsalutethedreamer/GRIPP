package org.gripp.android.gripp.fragments.Boiler_FeederFloor_Operator;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import org.gripp.android.gripp.R;
import org.gripp.android.gripp.utils.Constants;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;


/**
 * Created by harshgupta on 17/04/17.
 */

public class Fragment_BoilerEight_Shift_Initial_Detail extends BaseFragment {
    @BindView(R.id.fragment_initial_detail_date)
    TextView fragment_initial_detail_date;

    @BindView(R.id.fragment_initial_detail_shift)
    TextView fragment_initial_detail_shift;

    @BindView(R.id.fragment_initial_detail_group)
    TextView fragment_initial_detail_group;

    @BindView(R.id.initial_button)
    Button saveastext;

    String initial_date,initial_shift,initial_group,group_member_C,hname;
    int iyear,imonthadd;
    String iday,imonth;

    private Unbinder mUnbinder;
    public String dest;
    SimpleDateFormat df;

    public static Fragment_BoilerEight_Shift_Initial_Detail newInstance(){
        return new Fragment_BoilerEight_Shift_Initial_Detail();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView=inflater.inflate(R.layout.fragment_initial_detail,container,false);
        mUnbinder= ButterKnife.bind(this,rootView);

        saveastext.setVisibility(View.VISIBLE);

        Calendar c = Calendar.getInstance();
        df=new SimpleDateFormat("dd/MM/yyyy");
        initial_date=df.format(c.getTime());
        fragment_initial_detail_date.setText(initial_date);
        group_member_C="C(Shift Incharge=J Ram Murthy)";

        int hour=c.get(Calendar.HOUR_OF_DAY);
        iday=c.get(Calendar.DAY_OF_MONTH)<10?("0"+Integer.toString(c.get(Calendar.DAY_OF_MONTH))):Integer.toString(c.get(Calendar.DAY_OF_MONTH));
        imonthadd=c.get(Calendar.MONTH)+1;
        imonth=c.get(Calendar.MONTH)+1<10?"0"+Integer.toString(imonthadd):Integer.toString(imonthadd);
        iyear=c.get(Calendar.YEAR);
        Log.d("hour",Integer.toString(hour));
        if(hour>6 && hour<14){
            initial_shift="A";
        }else if(hour>=14 && hour<22){
            initial_shift="B";
        }else{
            initial_shift="C";
        }
        fragment_initial_detail_shift.setText(initial_shift);

        initial_group=findGroup();
        fragment_initial_detail_group.setText(initial_group);

        findUnit(rootView);
        Spinner spinner = (Spinner) rootView.findViewById(R.id.find_unit);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                // An item was selected. You can retrieve the selected item using
                // parent.getItemAtPosition(pos)
                String item = parent.getItemAtPosition(pos).toString();
                mSharedPreferences.edit().putString(Constants.unit,item).commit();
            }

            public void onNothingSelected(AdapterView<?> parent) {
                // Another interface callback
            }
        });
        return rootView;
    }

    @OnClick(R.id.initial_button)
    public void onClick(){
        checkforpermission();
        dest=roota+"/boilereight";
        String desta=dest+"/"+"boilereight"+mSharedPreferences.getString(Constants.unit,"unit1")+initial_shift.toLowerCase()+findGroup().toLowerCase()+iday+imonth+iyear+".pdf";
        File myfile=new File(dest);
        myfile.mkdirs();
        try {
            Document document = new Document(PageSize.A4);
            PdfWriter.getInstance(document,new FileOutputStream(desta));
            document.open();
            addTitlePage(document);
            document.close();
        }catch(IOException e){
            e.printStackTrace();
        }catch(DocumentException e){
            e.printStackTrace();
        }

    }

    private String findGroup(){
        Calendar cal1=Calendar.getInstance();
        Calendar cal2=Calendar.getInstance();
        cal1.set(2017,Calendar.APRIL,14,7,0,0);
        int hour=cal2.get(Calendar.HOUR_OF_DAY);

        long millis1=cal1.getTimeInMillis();
        long millis2=cal2.getTimeInMillis();
        long diff = millis2 - millis1;
        long diffdaysa=diff/(24*60*60*1000);
        long diffdays=diffdaysa%(8);
        Log.d("date please",Long.toString(diffdays)+"hhx");
        String initial_group_number;
        if(diffdays==0 || diffdays==1){
            if(hour>6 && hour<14){
                initial_group_number="A";
            }else if(hour>=14 && hour<22){
                initial_group_number="B";
            }else{
                initial_group_number="C";
            }
        }
        else if(diffdays==2 || diffdays==3){
            if(hour>6 && hour<14){
                initial_group_number="D";
            }else if(hour>=14 && hour<22){
                initial_group_number="A";
            }else{
                initial_group_number="B";
            }
        }
        else if(diffdays==4 || diffdays==5){
            if(hour>6 && hour<14){
                initial_group_number="C";
            }else if(hour>=14 && hour<22){
                initial_group_number="D";
            }else{
                initial_group_number="A";
            }
        }
        else{
            if(hour>6 && hour<14){
                initial_group_number="B";
            }else if(hour>=14 && hour<22){
                initial_group_number="C";
            }else{
                initial_group_number="D";
            }
        }
        return initial_group_number;
    }

    public void addTitlePage(Document document) throws DocumentException{
        Font catFont = new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.BOLD);
        Font catFont1=new Font(Font.FontFamily.TIMES_ROMAN,12,Font.BOLD);
        Font titleFont = new Font(Font.FontFamily.TIMES_ROMAN, 22, Font.BOLD
                | Font.UNDERLINE, BaseColor.GRAY);
        Font smallBold = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD);
        Font normal = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL);
        Paragraph paragraph=new Paragraph();
        addEmptyLine(paragraph,1);
        paragraph.add(new Paragraph("Boiler Feeder Floor",titleFont));
        addEmptyLine(paragraph,1);
        document.add(paragraph);

        PdfPTable table=new PdfPTable(5);
        PdfPCell c1 = new PdfPCell(new Phrase("Unit",catFont1));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);
        c1 = new PdfPCell(new Phrase("Date",catFont1));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);
        c1 = new PdfPCell(new Phrase("Shift",catFont1));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);
        c1 = new PdfPCell(new Phrase("Group",catFont1));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);
        c1 = new PdfPCell(new Phrase("Name",catFont1));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);
        table.setHeaderRows(1);
        table.addCell(mSharedPreferences.getString(Constants.unit,"unit1"));
        table.addCell(initial_date);
        table.addCell(initial_shift);
        table.addCell(initial_group);
        table.addCell(mSharedPreferences.getString(Constants.nameofoperator,""));
        Paragraph paragraph1=new Paragraph();
        addEmptyLine(paragraph1,2);
        document.add(table);
        document.add(paragraph1);

        Paragraph paragrapha=new Paragraph();
        paragrapha.add(new Paragraph("R C Feeder",titleFont));
        addEmptyLine(paragrapha,1);
        document.add(paragrapha);
        PdfPTable table1=new PdfPTable(12);
        PdfPCell c2 = new PdfPCell(new Phrase("",catFont1));
        c2.setColspan(2);
        c2.setHorizontalAlignment(Element.ALIGN_CENTER);
        table1.addCell(c2);
        c2 = new PdfPCell(new Phrase("A",catFont1));
        c2.setHorizontalAlignment(Element.ALIGN_CENTER);
        table1.addCell(c2);
        c2 = new PdfPCell(new Phrase("B",catFont1));
        c2.setHorizontalAlignment(Element.ALIGN_CENTER);
        table1.addCell(c2);
        c2 = new PdfPCell(new Phrase("C",catFont1));
        c2.setHorizontalAlignment(Element.ALIGN_CENTER);
        table1.addCell(c2);
        c2 = new PdfPCell(new Phrase("D",catFont1));
        c2.setHorizontalAlignment(Element.ALIGN_CENTER);
        table1.addCell(c2);
        c2 = new PdfPCell(new Phrase("E",catFont1));
        c2.setHorizontalAlignment(Element.ALIGN_CENTER);
        table1.addCell(c2);
        c2 = new PdfPCell(new Phrase("F",catFont1));
        c2.setHorizontalAlignment(Element.ALIGN_CENTER);
        table1.addCell(c2);
        c2 = new PdfPCell(new Phrase("G",catFont1));
        c2.setHorizontalAlignment(Element.ALIGN_CENTER);
        table1.addCell(c2);
        c2 = new PdfPCell(new Phrase("H",catFont1));
        c2.setHorizontalAlignment(Element.ALIGN_CENTER);
        table1.addCell(c2);
        c2 = new PdfPCell(new Phrase("J",catFont1));
        c2.setHorizontalAlignment(Element.ALIGN_CENTER);
        table1.addCell(c2);
        c2 = new PdfPCell(new Phrase("K",catFont1));
        c2.setHorizontalAlignment(Element.ALIGN_CENTER);
        table1.addCell(c2);
        table1.setHeaderRows(1);
        c2 = new PdfPCell(new Phrase("Gear Box Oil Level"));
        c2.setColspan(2);
        table1.addCell(c2);
        table1.addCell(mSharedPreferences.getString(Constants.gbol_A,""));
        table1.addCell(mSharedPreferences.getString(Constants.gbol_B,""));
        table1.addCell(mSharedPreferences.getString(Constants.gbol_C,""));
        table1.addCell(mSharedPreferences.getString(Constants.gbol_D,""));
        table1.addCell(mSharedPreferences.getString(Constants.gbol_E,""));
        table1.addCell(mSharedPreferences.getString(Constants.gbol_F,""));
        table1.addCell(mSharedPreferences.getString(Constants.gbol_G,""));
        table1.addCell(mSharedPreferences.getString(Constants.gbol_H,""));
        table1.addCell(mSharedPreferences.getString(Constants.gbol_J,""));
        table1.addCell(mSharedPreferences.getString(Constants.gbol_K,""));
        c2 = new PdfPCell(new Phrase("C.O.C Status"));
        c2.setColspan(2);
        table1.addCell(c2);
        table1.addCell(mSharedPreferences.getString(Constants.coc_A,""));
        table1.addCell(mSharedPreferences.getString(Constants.coc_B,""));
        table1.addCell(mSharedPreferences.getString(Constants.coc_C,""));
        table1.addCell(mSharedPreferences.getString(Constants.coc_D,""));
        table1.addCell(mSharedPreferences.getString(Constants.coc_E,""));
        table1.addCell(mSharedPreferences.getString(Constants.coc_F,""));
        table1.addCell(mSharedPreferences.getString(Constants.coc_G,""));
        table1.addCell(mSharedPreferences.getString(Constants.coc_H,""));
        table1.addCell(mSharedPreferences.getString(Constants.coc_J,""));
        table1.addCell(mSharedPreferences.getString(Constants.coc_K,""));
        c2 = new PdfPCell(new Phrase("C.O.C GB Oil Level"));
        c2.setColspan(2);
        table1.addCell(c2);
        table1.addCell(mSharedPreferences.getString(Constants.cgol_A,""));
        table1.addCell(mSharedPreferences.getString(Constants.cgol_B,""));
        table1.addCell(mSharedPreferences.getString(Constants.cgol_C,""));
        table1.addCell(mSharedPreferences.getString(Constants.cgol_D,""));
        table1.addCell(mSharedPreferences.getString(Constants.cgol_E,""));
        table1.addCell(mSharedPreferences.getString(Constants.cgol_F,""));
        table1.addCell(mSharedPreferences.getString(Constants.cgol_G,""));
        table1.addCell(mSharedPreferences.getString(Constants.cgol_H,""));
        table1.addCell(mSharedPreferences.getString(Constants.cgol_J,""));
        table1.addCell(mSharedPreferences.getString(Constants.cgol_K,""));
        c2 = new PdfPCell(new Phrase("FDR I/L Gate"));
        c2.setColspan(2);
        table1.addCell(c2);
        table1.addCell(mSharedPreferences.getString(Constants.fig_A,""));
        table1.addCell(mSharedPreferences.getString(Constants.fig_B,""));
        table1.addCell(mSharedPreferences.getString(Constants.fig_C,""));
        table1.addCell(mSharedPreferences.getString(Constants.fig_D,""));
        table1.addCell(mSharedPreferences.getString(Constants.fig_E,""));
        table1.addCell(mSharedPreferences.getString(Constants.fig_F,""));
        table1.addCell(mSharedPreferences.getString(Constants.fig_G,""));
        table1.addCell(mSharedPreferences.getString(Constants.fig_H,""));
        table1.addCell(mSharedPreferences.getString(Constants.fig_J,""));
        table1.addCell(mSharedPreferences.getString(Constants.fig_K,""));
        c2 = new PdfPCell(new Phrase("FDR O/L Gate"));
        c2.setColspan(2);
        table1.addCell(c2);
        table1.addCell(mSharedPreferences.getString(Constants.fog_A,""));
        table1.addCell(mSharedPreferences.getString(Constants.fog_B,""));
        table1.addCell(mSharedPreferences.getString(Constants.fog_C,""));
        table1.addCell(mSharedPreferences.getString(Constants.fog_D,""));
        table1.addCell(mSharedPreferences.getString(Constants.fog_E,""));
        table1.addCell(mSharedPreferences.getString(Constants.fog_F,""));
        table1.addCell(mSharedPreferences.getString(Constants.fog_G,""));
        table1.addCell(mSharedPreferences.getString(Constants.fog_H,""));
        table1.addCell(mSharedPreferences.getString(Constants.fog_J,""));
        table1.addCell(mSharedPreferences.getString(Constants.fog_K,""));
        c2 = new PdfPCell(new Phrase("Bunker O/L Gate"));
        c2.setColspan(2);
        table1.addCell(c2);
        table1.addCell(mSharedPreferences.getString(Constants.bog_A,""));
        table1.addCell(mSharedPreferences.getString(Constants.bog_B,""));
        table1.addCell(mSharedPreferences.getString(Constants.bog_C,""));
        table1.addCell(mSharedPreferences.getString(Constants.bog_D,""));
        table1.addCell(mSharedPreferences.getString(Constants.bog_E,""));
        table1.addCell(mSharedPreferences.getString(Constants.bog_F,""));
        table1.addCell(mSharedPreferences.getString(Constants.bog_G,""));
        table1.addCell(mSharedPreferences.getString(Constants.bog_H,""));
        table1.addCell(mSharedPreferences.getString(Constants.bog_J,""));
        table1.addCell(mSharedPreferences.getString(Constants.bog_K,""));
        c2 = new PdfPCell(new Phrase("Feeder seal air valve"));
        c2.setColspan(2);
        table1.addCell(c2);
        table1.addCell(mSharedPreferences.getString(Constants.fsav_A,""));
        table1.addCell(mSharedPreferences.getString(Constants.fsav_B,""));
        table1.addCell(mSharedPreferences.getString(Constants.fsav_C,""));
        table1.addCell(mSharedPreferences.getString(Constants.fsav_D,""));
        table1.addCell(mSharedPreferences.getString(Constants.fsav_E,""));
        table1.addCell(mSharedPreferences.getString(Constants.fsav_F,""));
        table1.addCell(mSharedPreferences.getString(Constants.fsav_G,""));
        table1.addCell(mSharedPreferences.getString(Constants.fsav_H,""));
        table1.addCell(mSharedPreferences.getString(Constants.fsav_J,""));
        table1.addCell(mSharedPreferences.getString(Constants.fsav_K,""));
        Paragraph paragraph2=new Paragraph();
        addEmptyLine(paragraph2,2);
        document.add(table1);
        document.add(paragraph2);

        Paragraph paragraph3=new Paragraph();
        paragraph3.add(new Paragraph("Air Pre Heater",titleFont));
        addEmptyLine(paragraph3,1);
        document.add(paragraph3);
        PdfPTable table2=new PdfPTable(5);
        PdfPCell c3 = new PdfPCell(new Phrase("",catFont1));
        c3.setHorizontalAlignment(Element.ALIGN_CENTER);
        table2.addCell(c3);
        c3 = new PdfPCell(new Phrase("PAPH-A",catFont1));
        c3.setHorizontalAlignment(Element.ALIGN_CENTER);
        table2.addCell(c3);
        c3 = new PdfPCell(new Phrase("PAPH-B",catFont1));
        c3.setHorizontalAlignment(Element.ALIGN_CENTER);
        table2.addCell(c3);
        c3 = new PdfPCell(new Phrase("SAPH-A",catFont1));
        c3.setHorizontalAlignment(Element.ALIGN_CENTER);
        table2.addCell(c3);
        c3 = new PdfPCell(new Phrase("SAPH-B",catFont1));
        c3.setHorizontalAlignment(Element.ALIGN_CENTER);
        table2.addCell(c3);
        table2.setHeaderRows(1);
        table2.addCell("Gear Box Oil Level");
        table2.addCell(mSharedPreferences.getString(Constants.paph_a_gearboxoillevel,""));
        table2.addCell(mSharedPreferences.getString(Constants.paph_b_gearboxoillevel,""));
        table2.addCell(mSharedPreferences.getString(Constants.saph_a_gearboxoillevel,""));
        table2.addCell(mSharedPreferences.getString(Constants.saph_b_gearboxoillevel,""));
        table2.addCell("Air Motor Air Pr");
        table2.addCell(mSharedPreferences.getString(Constants.paph_a_airmotorairpr,""));
        table2.addCell(mSharedPreferences.getString(Constants.paph_b_airmotorairpr,""));
        table2.addCell(mSharedPreferences.getString(Constants.saph_a_airmotorairpr,""));
        table2.addCell(mSharedPreferences.getString(Constants.saph_b_airmotorairpr,""));
        table2.addCell("Guide Bearing Lop I/S");
        table2.addCell(mSharedPreferences.getString(Constants.paph_a_guide_lopis,""));
        table2.addCell(mSharedPreferences.getString(Constants.paph_b_guide_lopis,""));
        table2.addCell(mSharedPreferences.getString(Constants.saph_a_guide_lopis,""));
        table2.addCell(mSharedPreferences.getString(Constants.saph_b_guide_lopis,""));
        table2.addCell("Guide Bearing Oil Pr");
        table2.addCell(mSharedPreferences.getString(Constants.paph_a_guide_oilpr,""));
        table2.addCell(mSharedPreferences.getString(Constants.paph_b_guide_oilpr,""));
        table2.addCell(mSharedPreferences.getString(Constants.saph_a_guide_oilpr,""));
        table2.addCell(mSharedPreferences.getString(Constants.saph_b_guide_oilpr,""));
        table2.addCell("Guide Bearing Oil Temp");
        table2.addCell(mSharedPreferences.getString(Constants.paph_a_guide_oiltemp,""));
        table2.addCell(mSharedPreferences.getString(Constants.paph_b_guide_oiltemp,""));
        table2.addCell(mSharedPreferences.getString(Constants.saph_a_guide_oiltemp,""));
        table2.addCell(mSharedPreferences.getString(Constants.saph_b_guide_oiltemp,""));
        table2.addCell("Guide Bearing Oil Lvl");
        table2.addCell(mSharedPreferences.getString(Constants.paph_a_guide_oillevel,""));
        table2.addCell(mSharedPreferences.getString(Constants.paph_b_guide_oillevel,""));
        table2.addCell(mSharedPreferences.getString(Constants.saph_a_guide_oillevel,""));
        table2.addCell(mSharedPreferences.getString(Constants.saph_b_guide_oillevel,""));
        table2.addCell("Guide Bearing Flow");
        table2.addCell(mSharedPreferences.getString(Constants.paph_a_guide_flow,""));
        table2.addCell(mSharedPreferences.getString(Constants.paph_b_guide_flow,""));
        table2.addCell(mSharedPreferences.getString(Constants.saph_a_guide_flow,""));
        table2.addCell(mSharedPreferences.getString(Constants.saph_b_guide_flow,""));
        table2.addCell("Support Bearing Lop I/S");
        table2.addCell(mSharedPreferences.getString(Constants.paph_a_support_lopis,""));
        table2.addCell(mSharedPreferences.getString(Constants.paph_b_support_lopis,""));
        table2.addCell(mSharedPreferences.getString(Constants.saph_a_support_lopis,""));
        table2.addCell(mSharedPreferences.getString(Constants.saph_b_support_lopis,""));
        table2.addCell("Support Bearing Oil Pr");
        table2.addCell(mSharedPreferences.getString(Constants.paph_a_support_oilpr,""));
        table2.addCell(mSharedPreferences.getString(Constants.paph_b_support_oilpr,""));
        table2.addCell(mSharedPreferences.getString(Constants.saph_a_support_oilpr,""));
        table2.addCell(mSharedPreferences.getString(Constants.saph_b_support_oilpr,""));
        table2.addCell("Support Bearing Oil Temp");
        table2.addCell(mSharedPreferences.getString(Constants.paph_a_support_oiltemp,""));
        table2.addCell(mSharedPreferences.getString(Constants.paph_b_support_oiltemp,""));
        table2.addCell(mSharedPreferences.getString(Constants.saph_a_support_oiltemp,""));
        table2.addCell(mSharedPreferences.getString(Constants.saph_b_support_oiltemp,""));
        table2.addCell("Support Bearing Oil Lvl");
        table2.addCell(mSharedPreferences.getString(Constants.paph_a_support_oillevel,""));
        table2.addCell(mSharedPreferences.getString(Constants.paph_b_support_oillevel,""));
        table2.addCell(mSharedPreferences.getString(Constants.saph_a_support_oillevel,""));
        table2.addCell(mSharedPreferences.getString(Constants.saph_b_support_oillevel,""));
        table2.addCell("Support Bearing Flow");
        table2.addCell(mSharedPreferences.getString(Constants.paph_a_support_flow,""));
        table2.addCell(mSharedPreferences.getString(Constants.paph_b_support_flow,""));
        table2.addCell(mSharedPreferences.getString(Constants.saph_a_support_flow,""));
        table2.addCell(mSharedPreferences.getString(Constants.saph_b_support_flow,""));
        Paragraph paragraph4=new Paragraph();
        addEmptyLine(paragraph4,2);
        document.add(table2);
        document.add(paragraph4);

        Paragraph paragraph5=new Paragraph();
        paragraph5.add(new Paragraph("Burner Isolation Gate Status",titleFont));
        addEmptyLine(paragraph5,1);
        paragraph5.add(new Paragraph(mSharedPreferences.getString(Constants.mill_BIG,"")));
        addEmptyLine(paragraph5,2);
        paragraph5.add(new Paragraph("BCW Status",titleFont));
        addEmptyLine(paragraph5,1);
        paragraph5.add(new Paragraph(mSharedPreferences.getString(Constants.BCW_Status,"")));
        addEmptyLine(paragraph5,2);
        paragraph5.add(new Paragraph("Remarks",titleFont));
        addEmptyLine(paragraph5,1);
        paragraph5.add(new Paragraph(mSharedPreferences.getString(Constants.remarks,"")));
        document.add(paragraph5);

    }

    private static void addEmptyLine(Paragraph paragraph, int number) {
        for (int i = 0; i < number; i++) {
            paragraph.add(new Paragraph(" "));
        }
    }

    public void findUnit(View v){
        Spinner spinner = (Spinner) v.findViewById(R.id.find_unit);
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(),
                R.array.unit_array, R.layout.spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinner.setAdapter(adapter);
        int position=0;
        if(mSharedPreferences.getString(Constants.unit,"unit1").equals("unit2")){
            position=1;
            Log.d("yope","one");
        }else{
            Log.d("yope",mSharedPreferences.getString(Constants.unit,"unit1"));
        }
        spinner.setSelection(position);
    }
}
