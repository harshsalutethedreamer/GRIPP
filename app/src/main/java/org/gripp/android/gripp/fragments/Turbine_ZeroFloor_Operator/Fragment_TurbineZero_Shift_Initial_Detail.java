package org.gripp.android.gripp.fragments.Turbine_ZeroFloor_Operator;


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
import org.gripp.android.gripp.fragments.Boiler_FeederFloor_Operator.BaseFragment;
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

public class Fragment_TurbineZero_Shift_Initial_Detail extends BaseFragment {
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

    public static Fragment_TurbineZero_Shift_Initial_Detail newInstance(){
        return new Fragment_TurbineZero_Shift_Initial_Detail();
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
        Log.i("click","working");
        dest=roota+"/turbinezero";
        String desta=dest+"/"+"turbine_zero_"+mSharedPreferences.getString(Constants.unit,"")+initial_shift.toLowerCase()+findGroup().toLowerCase()+iday+imonth+iyear+".pdf";
        File myfile=new File(dest);
        myfile.mkdirs();
        try {
            Document document = new Document(PageSize.A4);
            PdfWriter.getInstance(document,new FileOutputStream(desta));
            document.open();
            addTitlePageturbinezero(document);
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

    public void addTitlePageturbinezero(Document document) throws DocumentException{
        Font catFont = new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.BOLD);
        Font catFont1=new Font(Font.FontFamily.TIMES_ROMAN,12,Font.BOLD);
        Font titleFont = new Font(Font.FontFamily.TIMES_ROMAN, 22, Font.BOLD
                | Font.UNDERLINE, BaseColor.GRAY);
        Font smallBold = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD);
        Font normal = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL);
        Paragraph paragraph=new Paragraph();
        addEmptyLine(paragraph,1);
        paragraph.add(new Paragraph("Turbine Zero Meter Operator's Log Sheet",titleFont));
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
        table.addCell(mSharedPreferences.getString(Constants.unit,""));
        table.addCell(initial_shift);
        table.addCell(initial_group);
        table.addCell(initial_date);
        table.addCell(mSharedPreferences.getString(Constants.nameofoperator,""));
        Paragraph paragraph1=new Paragraph();
        addEmptyLine(paragraph1,2);
        document.add(table);
        document.add(paragraph1);

        Paragraph paragraph2=new Paragraph();
        paragraph2.add(new Paragraph("Condensate Extraction Pumps",titleFont));
        addEmptyLine(paragraph2,1);
        document.add(paragraph2);
        PdfPTable table1=new PdfPTable(4);
        PdfPCell c3 = new PdfPCell(new Phrase("",catFont1));
        c3.setHorizontalAlignment(Element.ALIGN_CENTER);
        table1.addCell(c3);
        c3 = new PdfPCell(new Phrase("CEP-A",catFont1));
        c3.setHorizontalAlignment(Element.ALIGN_CENTER);
        table1.addCell(c3);
        c3 = new PdfPCell(new Phrase("CEP-B",catFont1));
        c3.setHorizontalAlignment(Element.ALIGN_CENTER);
        table1.addCell(c3);
        c3 = new PdfPCell(new Phrase("CEP-C",catFont1));
        c3.setHorizontalAlignment(Element.ALIGN_CENTER);
        table1.addCell(c3);
        table1.setHeaderRows(1);
        table1.addCell("CEP Pump In Service");
        table1.addCell(mSharedPreferences.getString(Constants.turbinezerocep[0],""));
        table1.addCell(mSharedPreferences.getString(Constants.turbinezerocep[1],""));
        table1.addCell(mSharedPreferences.getString(Constants.turbinezerocep[2],""));
        table1.addCell("Thrust Brg Oil Level");
        table1.addCell(mSharedPreferences.getString(Constants.turbinezerocep[3],""));
        table1.addCell(mSharedPreferences.getString(Constants.turbinezerocep[4],""));
        table1.addCell(mSharedPreferences.getString(Constants.turbinezerocep[5],""));
        Paragraph paragraph3=new Paragraph();
        addEmptyLine(paragraph3,2);
        document.add(table1);
        document.add(paragraph3);

        Paragraph paragraph4=new Paragraph();
        paragraph4.add(new Paragraph("Seal Oil System",titleFont));
        addEmptyLine(paragraph4,1);
        document.add(paragraph4);
        PdfPTable table2=new PdfPTable(5);
        PdfPCell c4 = new PdfPCell(new Phrase("SOT Level",catFont1));
        c4.setRowspan(2);
        c4.setHorizontalAlignment(Element.ALIGN_CENTER);
        table2.addCell(c4);
        c4 = new PdfPCell(new Phrase("H2 Pressure",catFont1));
        c4.setRowspan(2);
        c4.setHorizontalAlignment(Element.ALIGN_CENTER);
        table2.addCell(c4);
        c4 = new PdfPCell(new Phrase("H2 Purity",catFont1));
        c4.setRowspan(2);
        c4.setHorizontalAlignment(Element.ALIGN_CENTER);
        table2.addCell(c4);
        c4 = new PdfPCell(new Phrase("MDBFP Coolers",catFont1));
        c4.setColspan(2);
        c4.setHorizontalAlignment(Element.ALIGN_CENTER);
        table2.addCell(c4);
        table2.setHeaderRows(1);
        c4 = new PdfPCell(new Phrase("Lo Cooler IS/OL Temp",catFont1));
        c4.setHorizontalAlignment(Element.ALIGN_CENTER);
        table2.addCell(c4);
        c4 = new PdfPCell(new Phrase("WO Cooler IS/OL Temp",catFont1));
        c4.setHorizontalAlignment(Element.ALIGN_CENTER);
        table2.addCell(c4);
        table2.addCell(mSharedPreferences.getString(Constants.turbinezerosealoilsystem[0],""));
        table2.addCell(mSharedPreferences.getString(Constants.turbinezerosealoilsystem[11],""));
        table2.addCell(mSharedPreferences.getString(Constants.turbinezerosealoilsystem[12],""));
        table2.addCell(mSharedPreferences.getString(Constants.turbinezerosealoilsystem[13],""));
        table2.addCell(mSharedPreferences.getString(Constants.turbinezerosealoilsystem[14],""));
        Paragraph paragraph5=new Paragraph();
        addEmptyLine(paragraph5,1);
        document.add(table2);
        document.add(paragraph5);

        PdfPTable table3=new PdfPTable(10);
        PdfPCell c5 = new PdfPCell(new Phrase("H2 Side SOP",catFont1));
        c5.setHorizontalAlignment(Element.ALIGN_CENTER);
        c5.setColspan(5);
        table3.addCell(c5);
        c5 = new PdfPCell(new Phrase("Air Side SOP",catFont1));
        c5.setHorizontalAlignment(Element.ALIGN_CENTER);
        c5.setColspan(5);
        table3.addCell(c5);
        table3.setHeaderRows(1);
        c5 = new PdfPCell(new Phrase("Disch Pr",catFont1));
        c5.setHorizontalAlignment(Element.ALIGN_CENTER);
        table3.addCell(c5);
        c5 = new PdfPCell(new Phrase("Filter IS",catFont1));
        c5.setHorizontalAlignment(Element.ALIGN_CENTER);
        table3.addCell(c5);
        c5 = new PdfPCell(new Phrase("Filter DP",catFont1));
        c5.setHorizontalAlignment(Element.ALIGN_CENTER);
        table3.addCell(c5);
        c5 = new PdfPCell(new Phrase("Cooler O/L Temp",catFont1));
        c5.setHorizontalAlignment(Element.ALIGN_CENTER);
        table3.addCell(c5);
        c5 = new PdfPCell(new Phrase("SOP-H2 DP",catFont1));
        c5.setHorizontalAlignment(Element.ALIGN_CENTER);
        table3.addCell(c5);
        c5 = new PdfPCell(new Phrase("SOP-A Disch Pr",catFont1));
        c5.setHorizontalAlignment(Element.ALIGN_CENTER);
        table3.addCell(c5);
        c5 = new PdfPCell(new Phrase("SOP-B Disch Pr",catFont1));
        c5.setHorizontalAlignment(Element.ALIGN_CENTER);
        table3.addCell(c5);
        c5 = new PdfPCell(new Phrase("Filter IS",catFont1));
        c5.setHorizontalAlignment(Element.ALIGN_CENTER);
        table3.addCell(c5);
        c5 = new PdfPCell(new Phrase("Filter DP",catFont1));
        c5.setHorizontalAlignment(Element.ALIGN_CENTER);
        table3.addCell(c5);
        c5 = new PdfPCell(new Phrase("Cooler O/L Temp",catFont1));
        c5.setHorizontalAlignment(Element.ALIGN_CENTER);
        table3.addCell(c5);
        table3.addCell(mSharedPreferences.getString(Constants.turbinezerosealoilsystem[1],""));
        table3.addCell(mSharedPreferences.getString(Constants.turbinezerosealoilsystem[2],""));
        table3.addCell(mSharedPreferences.getString(Constants.turbinezerosealoilsystem[3],""));
        table3.addCell(mSharedPreferences.getString(Constants.turbinezerosealoilsystem[4],""));
        table3.addCell(mSharedPreferences.getString(Constants.turbinezerosealoilsystem[5],""));
        table3.addCell(mSharedPreferences.getString(Constants.turbinezerosealoilsystem[6],""));
        table3.addCell(mSharedPreferences.getString(Constants.turbinezerosealoilsystem[7],""));
        table3.addCell(mSharedPreferences.getString(Constants.turbinezerosealoilsystem[8],""));
        table3.addCell(mSharedPreferences.getString(Constants.turbinezerosealoilsystem[9],""));
        table3.addCell(mSharedPreferences.getString(Constants.turbinezerosealoilsystem[10],""));
        document.add(table3);
        document.add(paragraph3);

        Paragraph paragraph6=new Paragraph();
        paragraph6.add(new Paragraph("Vacuum Pumps",titleFont));
        addEmptyLine(paragraph6,1);
        document.add(paragraph6);
        PdfPTable table4=new PdfPTable(4);
        PdfPCell c6 = new PdfPCell(new Phrase("",catFont1));
        c6.setHorizontalAlignment(Element.ALIGN_CENTER);
        table4.addCell(c6);
        c6 = new PdfPCell(new Phrase("Seal Water IL/OL Temp",catFont1));
        c6.setHorizontalAlignment(Element.ALIGN_CENTER);
        table4.addCell(c6);
        c6 = new PdfPCell(new Phrase("Filter IS/DP",catFont1));
        c6.setHorizontalAlignment(Element.ALIGN_CENTER);
        table4.addCell(c6);
        c6 = new PdfPCell(new Phrase("CW I/L Pressure",catFont1));
        c6.setHorizontalAlignment(Element.ALIGN_CENTER);
        table4.addCell(c6);
        table4.setHeaderRows(1);
        table4.addCell("Vacuum Pump A");
        table4.addCell(mSharedPreferences.getString(Constants.turbinezerovp[0],""));
        table4.addCell(mSharedPreferences.getString(Constants.turbinezerovp[2],""));
        table4.addCell(mSharedPreferences.getString(Constants.turbinezerovp[4],""));
        table4.addCell("Vacuum Pump B");
        table4.addCell(mSharedPreferences.getString(Constants.turbinezerovp[1],""));
        table4.addCell(mSharedPreferences.getString(Constants.turbinezerovp[3],""));
        table4.addCell(mSharedPreferences.getString(Constants.turbinezerovp[5],""));
        document.add(table4);
        document.add(paragraph3);

        Paragraph paragraph7=new Paragraph();
        paragraph7.add(new Paragraph("Control Fluid System",titleFont));
        addEmptyLine(paragraph7,1);
        document.add(paragraph7);
        PdfPTable table5=new PdfPTable(10);
        PdfPCell c7 = new PdfPCell(new Phrase("CFT Level",catFont1));
        c7.setHorizontalAlignment(Element.ALIGN_CENTER);
        table5.addCell(c7);
        c7 = new PdfPCell(new Phrase("CF Pump I/S",catFont1));
        c7.setHorizontalAlignment(Element.ALIGN_CENTER);
        table5.addCell(c7);
        c7 = new PdfPCell(new Phrase("Disch Pr HP",catFont1));
        c7.setHorizontalAlignment(Element.ALIGN_CENTER);
        table5.addCell(c7);
        c7 = new PdfPCell(new Phrase("Disch Pr LP",catFont1));
        c7.setHorizontalAlignment(Element.ALIGN_CENTER);
        table5.addCell(c7);
        c7 = new PdfPCell(new Phrase("VEF I/S",catFont1));
        c7.setHorizontalAlignment(Element.ALIGN_CENTER);
        table5.addCell(c7);
        c7 = new PdfPCell(new Phrase("Cooler I/S",catFont1));
        c7.setHorizontalAlignment(Element.ALIGN_CENTER);
        table5.addCell(c7);
        c7 = new PdfPCell(new Phrase("Tank Temp",catFont1));
        c7.setHorizontalAlignment(Element.ALIGN_CENTER);
        table5.addCell(c7);
        c7 = new PdfPCell(new Phrase("Filter IS/DP",catFont1));
        c7.setHorizontalAlignment(Element.ALIGN_CENTER);
        table5.addCell(c7);
        c7 = new PdfPCell(new Phrase("R/C pp IS/Disch Pr",catFont1));
        c7.setHorizontalAlignment(Element.ALIGN_CENTER);
        table5.addCell(c7);
        c7 = new PdfPCell(new Phrase("DOT Level",catFont1));
        c7.setHorizontalAlignment(Element.ALIGN_CENTER);
        table5.addCell(c7);
        table5.setHeaderRows(1);
        table5.addCell(mSharedPreferences.getString(Constants.turbinezerocontrofluid[0],""));
        table5.addCell(mSharedPreferences.getString(Constants.turbinezerocontrofluid[1],""));
        table5.addCell(mSharedPreferences.getString(Constants.turbinezerocontrofluid[2],""));
        table5.addCell(mSharedPreferences.getString(Constants.turbinezerocontrofluid[3],""));
        table5.addCell(mSharedPreferences.getString(Constants.turbinezerocontrofluid[4],""));
        table5.addCell(mSharedPreferences.getString(Constants.turbinezerocontrofluid[5],""));
        table5.addCell(mSharedPreferences.getString(Constants.turbinezerocontrofluid[6],""));
        table5.addCell(mSharedPreferences.getString(Constants.turbinezerocontrofluid[7],""));
        table5.addCell(mSharedPreferences.getString(Constants.turbinezerocontrofluid[8],""));
        table5.addCell(mSharedPreferences.getString(Constants.turbinezerocontrofluid[9],""));
        document.add(table5);
        document.add(paragraph3);

        Paragraph paragraph8=new Paragraph();
        paragraph8.add(new Paragraph("DMCW System",titleFont));
        addEmptyLine(paragraph8,1);
        document.add(paragraph8);
        PdfPTable table6=new PdfPTable(12);
        PdfPCell c8 = new PdfPCell(new Phrase("Pump-A",catFont1));
        c8.setHorizontalAlignment(Element.ALIGN_CENTER);
        c8.setColspan(4);
        table6.addCell(c8);
        c8 = new PdfPCell(new Phrase("Pump-B",catFont1));
        c8.setHorizontalAlignment(Element.ALIGN_CENTER);
        c8.setColspan(4);
        table6.addCell(c8);
        c8 = new PdfPCell(new Phrase("Pump-C",catFont1));
        c8.setHorizontalAlignment(Element.ALIGN_CENTER);
        c8.setColspan(4);
        table6.addCell(c8);
        table6.setHeaderRows(1);
        c8 = new PdfPCell(new Phrase("Condition",catFont1));
        c8.setHorizontalAlignment(Element.ALIGN_CENTER);
        table6.addCell(c8);
        c8 = new PdfPCell(new Phrase("Suction Valve",catFont1));
        c8.setHorizontalAlignment(Element.ALIGN_CENTER);
        table6.addCell(c8);
        c8 = new PdfPCell(new Phrase("Suction Pr",catFont1));
        c8.setHorizontalAlignment(Element.ALIGN_CENTER);
        table6.addCell(c8);
        c8 = new PdfPCell(new Phrase("Discharge Pr",catFont1));
        c8.setHorizontalAlignment(Element.ALIGN_CENTER);
        table6.addCell(c8);
        c8 = new PdfPCell(new Phrase("Condition",catFont1));
        c8.setHorizontalAlignment(Element.ALIGN_CENTER);
        table6.addCell(c8);
        c8 = new PdfPCell(new Phrase("Suction Valve",catFont1));
        c8.setHorizontalAlignment(Element.ALIGN_CENTER);
        table6.addCell(c8);
        c8 = new PdfPCell(new Phrase("Suction Pr",catFont1));
        c8.setHorizontalAlignment(Element.ALIGN_CENTER);
        table6.addCell(c8);
        c8 = new PdfPCell(new Phrase("Discharge Pr",catFont1));
        c8.setHorizontalAlignment(Element.ALIGN_CENTER);
        table6.addCell(c8);
        c8 = new PdfPCell(new Phrase("Condition",catFont1));
        c8.setHorizontalAlignment(Element.ALIGN_CENTER);
        table6.addCell(c8);
        c8 = new PdfPCell(new Phrase("Suction Valve",catFont1));
        c8.setHorizontalAlignment(Element.ALIGN_CENTER);
        table6.addCell(c8);
        c8 = new PdfPCell(new Phrase("Suction Pr",catFont1));
        c8.setHorizontalAlignment(Element.ALIGN_CENTER);
        table6.addCell(c8);
        c8 = new PdfPCell(new Phrase("Discharge Pr",catFont1));
        c8.setHorizontalAlignment(Element.ALIGN_CENTER);
        table6.addCell(c7);
        table6.addCell(mSharedPreferences.getString(Constants.turbineacw[0],""));
        table6.addCell(mSharedPreferences.getString(Constants.turbineacw[3],""));
        table6.addCell(mSharedPreferences.getString(Constants.turbineacw[6],""));
        table6.addCell(mSharedPreferences.getString(Constants.turbineacw[9],""));
        table6.addCell(mSharedPreferences.getString(Constants.turbineacw[1],""));
        table6.addCell(mSharedPreferences.getString(Constants.turbineacw[4],""));
        table6.addCell(mSharedPreferences.getString(Constants.turbineacw[7],""));
        table6.addCell(mSharedPreferences.getString(Constants.turbineacw[10],""));
        table6.addCell(mSharedPreferences.getString(Constants.turbineacw[2],""));
        table6.addCell(mSharedPreferences.getString(Constants.turbineacw[5],""));
        table6.addCell(mSharedPreferences.getString(Constants.turbineacw[8],""));
        table6.addCell(mSharedPreferences.getString(Constants.turbineacw[11],""));
        document.add(table6);
        document.add(paragraph3);

        Paragraph paragraph9=new Paragraph();
        paragraph9.add(new Paragraph("ACW System",titleFont));
        addEmptyLine(paragraph9,1);
        document.add(paragraph9);
        PdfPTable table7=new PdfPTable(12);
        PdfPCell c9 = new PdfPCell(new Phrase("Pump-A",catFont1));
        c9.setHorizontalAlignment(Element.ALIGN_CENTER);
        c9.setColspan(4);
        table7.addCell(c9);
        c9 = new PdfPCell(new Phrase("Pump-B",catFont1));
        c9.setHorizontalAlignment(Element.ALIGN_CENTER);
        c9.setColspan(4);
        table7.addCell(c9);
        c9 = new PdfPCell(new Phrase("Pump-C",catFont1));
        c9.setHorizontalAlignment(Element.ALIGN_CENTER);
        c9.setColspan(4);
        table7.addCell(c9);
        table7.setHeaderRows(1);
        c9 = new PdfPCell(new Phrase("Condition",catFont1));
        c9.setHorizontalAlignment(Element.ALIGN_CENTER);
        table7.addCell(c9);
        c9 = new PdfPCell(new Phrase("Suction Valve",catFont1));
        c9.setHorizontalAlignment(Element.ALIGN_CENTER);
        table7.addCell(c9);
        c9 = new PdfPCell(new Phrase("Suction Pr",catFont1));
        c9.setHorizontalAlignment(Element.ALIGN_CENTER);
        table7.addCell(c9);
        c9 = new PdfPCell(new Phrase("Discharge Pr",catFont1));
        c9.setHorizontalAlignment(Element.ALIGN_CENTER);
        table7.addCell(c9);
        c9 = new PdfPCell(new Phrase("Condition",catFont1));
        c9.setHorizontalAlignment(Element.ALIGN_CENTER);
        table7.addCell(c9);
        c9 = new PdfPCell(new Phrase("Suction Valve",catFont1));
        c9.setHorizontalAlignment(Element.ALIGN_CENTER);
        table7.addCell(c9);
        c9 = new PdfPCell(new Phrase("Suction Pr",catFont1));
        c9.setHorizontalAlignment(Element.ALIGN_CENTER);
        table7.addCell(c9);
        c9 = new PdfPCell(new Phrase("Discharge Pr",catFont1));
        c9.setHorizontalAlignment(Element.ALIGN_CENTER);
        table7.addCell(c9);
        c9 = new PdfPCell(new Phrase("Condition",catFont1));
        c9.setHorizontalAlignment(Element.ALIGN_CENTER);
        table7.addCell(c9);
        c9 = new PdfPCell(new Phrase("Suction Valve",catFont1));
        c9.setHorizontalAlignment(Element.ALIGN_CENTER);
        table7.addCell(c9);
        c9 = new PdfPCell(new Phrase("Suction Pr",catFont1));
        c9.setHorizontalAlignment(Element.ALIGN_CENTER);
        table7.addCell(c9);
        c9 = new PdfPCell(new Phrase("Discharge Pr",catFont1));
        c9.setHorizontalAlignment(Element.ALIGN_CENTER);
        table7.addCell(c9);
        table7.addCell(mSharedPreferences.getString(Constants.turbineacw[12],""));
        table7.addCell(mSharedPreferences.getString(Constants.turbineacw[15],""));
        table7.addCell(mSharedPreferences.getString(Constants.turbineacw[18],""));
        table7.addCell(mSharedPreferences.getString(Constants.turbineacw[21],""));
        table7.addCell(mSharedPreferences.getString(Constants.turbineacw[13],""));
        table7.addCell(mSharedPreferences.getString(Constants.turbineacw[16],""));
        table7.addCell(mSharedPreferences.getString(Constants.turbineacw[19],""));
        table7.addCell(mSharedPreferences.getString(Constants.turbineacw[22],""));
        table7.addCell(mSharedPreferences.getString(Constants.turbineacw[14],""));
        table7.addCell(mSharedPreferences.getString(Constants.turbineacw[17],""));
        table7.addCell(mSharedPreferences.getString(Constants.turbineacw[20],""));
        table7.addCell(mSharedPreferences.getString(Constants.turbineacw[23],""));
        document.add(table7);
        document.add(paragraph3);

        Paragraph paragraph10=new Paragraph();
        paragraph10.add(new Paragraph("TDBFP Oil System",titleFont));
        addEmptyLine(paragraph10,1);
        document.add(paragraph10);
        PdfPTable table8=new PdfPTable(8);
        PdfPCell c10 = new PdfPCell(new Phrase("",catFont1));
        c10.setHorizontalAlignment(Element.ALIGN_CENTER);
        table8.addCell(c10);
        c10 = new PdfPCell(new Phrase("Tank Level",catFont1));
        c10.setHorizontalAlignment(Element.ALIGN_CENTER);
        table8.addCell(c10);
        c10 = new PdfPCell(new Phrase("LOP I/S",catFont1));
        c10.setHorizontalAlignment(Element.ALIGN_CENTER);
        table8.addCell(c10);
        c10 = new PdfPCell(new Phrase("Disch Pr",catFont1));
        c10.setHorizontalAlignment(Element.ALIGN_CENTER);
        table8.addCell(c10);
        c10 = new PdfPCell(new Phrase("Filter IS",catFont1));
        c10.setHorizontalAlignment(Element.ALIGN_CENTER);
        table8.addCell(c10);
        c10 = new PdfPCell(new Phrase("Filter DP",catFont1));
        c10.setHorizontalAlignment(Element.ALIGN_CENTER);
        table8.addCell(c10);
        c10 = new PdfPCell(new Phrase("Lub Oil Pr",catFont1));
        c10.setHorizontalAlignment(Element.ALIGN_CENTER);
        table8.addCell(c10);
        c10 = new PdfPCell(new Phrase("V E Fan",catFont1));
        c10.setHorizontalAlignment(Element.ALIGN_CENTER);
        table8.addCell(c10);
        table8.setHeaderRows(1);
        table8.addCell("TDBFP-A");
        table8.addCell(mSharedPreferences.getString(Constants.turbinezerotdbfpoilone[0],""));
        table8.addCell(mSharedPreferences.getString(Constants.turbinezerotdbfpoilone[2],""));
        table8.addCell(mSharedPreferences.getString(Constants.turbinezerotdbfpoilone[4],""));
        table8.addCell(mSharedPreferences.getString(Constants.turbinezerotdbfpoilone[6],""));
        table8.addCell(mSharedPreferences.getString(Constants.turbinezerotdbfpoilone[8],""));
        table8.addCell(mSharedPreferences.getString(Constants.turbinezerotdbfpoilone[10],""));
        table8.addCell(mSharedPreferences.getString(Constants.turbinezerotdbfpoilone[12],""));
        table8.addCell("TDBFP-B");
        table8.addCell(mSharedPreferences.getString(Constants.turbinezerotdbfpoilone[1],""));
        table8.addCell(mSharedPreferences.getString(Constants.turbinezerotdbfpoilone[3],""));
        table8.addCell(mSharedPreferences.getString(Constants.turbinezerotdbfpoilone[5],""));
        table8.addCell(mSharedPreferences.getString(Constants.turbinezerotdbfpoilone[7],""));
        table8.addCell(mSharedPreferences.getString(Constants.turbinezerotdbfpoilone[9],""));
        table8.addCell(mSharedPreferences.getString(Constants.turbinezerotdbfpoilone[11],""));
        table8.addCell(mSharedPreferences.getString(Constants.turbinezerotdbfpoilone[13],""));
        document.add(table8);
        document.add(paragraph5);

        PdfPTable table9=new PdfPTable(7);
        PdfPCell c11 = new PdfPCell(new Phrase("",catFont1));
        c11.setHorizontalAlignment(Element.ALIGN_CENTER);
        table9.addCell(c11);
        c11 = new PdfPCell(new Phrase("Water Level",catFont1));
        c11.setHorizontalAlignment(Element.ALIGN_CENTER);
        table9.addCell(c11);
        c11 = new PdfPCell(new Phrase("Water Temp",catFont1));
        c11.setHorizontalAlignment(Element.ALIGN_CENTER);
        table9.addCell(c11);
        c11 = new PdfPCell(new Phrase("Gear Box Oil Lvl",catFont1));
        c11.setHorizontalAlignment(Element.ALIGN_CENTER);
        table9.addCell(c11);
        c11 = new PdfPCell(new Phrase("CF Sucn Flow",catFont1));
        c11.setHorizontalAlignment(Element.ALIGN_CENTER);
        table9.addCell(c11);
        c11 = new PdfPCell(new Phrase("Heater I/S",catFont1));
        c11.setHorizontalAlignment(Element.ALIGN_CENTER);
        table9.addCell(c11);
        c11 = new PdfPCell(new Phrase("Booster pp I/S",catFont1));
        c11.setHorizontalAlignment(Element.ALIGN_CENTER);
        table9.addCell(c11);
        table9.setHeaderRows(1);
        table9.addCell("TDBFP-A Centrifudge");
        table9.addCell(mSharedPreferences.getString(Constants.turbinezerotdbfpoiltwo[0],""));
        table9.addCell(mSharedPreferences.getString(Constants.turbinezerotdbfpoiltwo[2],""));
        table9.addCell(mSharedPreferences.getString(Constants.turbinezerotdbfpoiltwo[4],""));
        table9.addCell(mSharedPreferences.getString(Constants.turbinezerotdbfpoiltwo[6],""));
        table9.addCell(mSharedPreferences.getString(Constants.turbinezerotdbfpoiltwo[8],""));
        table9.addCell(mSharedPreferences.getString(Constants.turbinezerotdbfpoiltwo[10],""));
        table9.addCell("TDBFP-B Centrifudge");
        table9.addCell(mSharedPreferences.getString(Constants.turbinezerotdbfpoiltwo[1],""));
        table9.addCell(mSharedPreferences.getString(Constants.turbinezerotdbfpoiltwo[3],""));
        table9.addCell(mSharedPreferences.getString(Constants.turbinezerotdbfpoiltwo[5],""));
        table9.addCell(mSharedPreferences.getString(Constants.turbinezerotdbfpoiltwo[7],""));
        table9.addCell(mSharedPreferences.getString(Constants.turbinezerotdbfpoiltwo[9],""));
        table9.addCell(mSharedPreferences.getString(Constants.turbinezerotdbfpoiltwo[11],""));
        document.add(table9);
        document.add(paragraph3);

        Paragraph paragraph11=new Paragraph();
        paragraph11.add(new Paragraph("Other Equipment",titleFont));
        addEmptyLine(paragraph11,1);
        document.add(paragraph11);
        PdfPTable table10=new PdfPTable(5);
        PdfPCell c12 = new PdfPCell(new Phrase("PHE In Service",catFont1));
        c12.setHorizontalAlignment(Element.ALIGN_CENTER);
        c12.setRowspan(2);
        table10.addCell(c12);
        c12 = new PdfPCell(new Phrase("Condenser Pit Dewatering Pump I/S",catFont1));
        c12.setHorizontalAlignment(Element.ALIGN_CENTER);
        c12.setRowspan(2);
        table10.addCell(c12);
        c12 = new PdfPCell(new Phrase("Cylinder Status(H2/CO2/N2)",catFont1));
        c12.setColspan(3);
        c12.setHorizontalAlignment(Element.ALIGN_CENTER);
        table10.addCell(c12);
        table10.setHeaderRows(1);
        table10.addCell("H2");
        table10.addCell("CO2");
        table10.addCell("N2");
        table10.addCell(mSharedPreferences.getString(Constants.turbinezerocfs[0],""));
        table10.addCell(mSharedPreferences.getString(Constants.turbinezerocfs[1],""));
        table10.addCell(mSharedPreferences.getString(Constants.turbinezerocfs[2],""));
        table10.addCell(mSharedPreferences.getString(Constants.turbinezerocfs[3],""));
        table10.addCell(mSharedPreferences.getString(Constants.turbinezerocfs[4],""));
        document.add(table10);
        document.add(paragraph3);

        Paragraph paragraph12=new Paragraph();
        paragraph12.add(new Paragraph("Remarks",titleFont));
        addEmptyLine(paragraph12,1);
        paragraph12.add(new Paragraph(mSharedPreferences.getString(Constants.remarksturbinezerometer,"")));
        document.add(paragraph12);

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
