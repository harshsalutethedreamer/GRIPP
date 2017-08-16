package org.gripp.android.gripp.fragments.Turbine_EightMeterFloor_Operator;


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

public class Fragment_TurbineEight_Shift_Initial_Detail extends BaseFragment {
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

    public static Fragment_TurbineEight_Shift_Initial_Detail newInstance(){
        return new Fragment_TurbineEight_Shift_Initial_Detail();
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
        dest=roota+"/turbineeight";
        String desta=dest+"/"+"turbine_eight_"+mSharedPreferences.getString(Constants.unit,"unit1")+initial_shift.toLowerCase()+findGroup().toLowerCase()+iday+imonth+iyear+".pdf";
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
        paragraph.add(new Paragraph("Turbine 8.5 Operator's Log Sheet",titleFont));
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
        table.addCell(initial_shift);
        table.addCell(initial_group);
        table.addCell(initial_date);
        table.addCell(mSharedPreferences.getString(Constants.nameofoperator,""));
        Paragraph paragraph1=new Paragraph();
        addEmptyLine(paragraph1,2);
        document.add(table);
        document.add(paragraph1);

        Paragraph paragrapha=new Paragraph();
        paragrapha.add(new Paragraph("Primary Water System",titleFont));
        addEmptyLine(paragrapha,1);
        document.add(paragrapha);
        PdfPTable table1=new PdfPTable(8);
        PdfPCell c3 = new PdfPCell(new Phrase("Tank Level",catFont1));
        c3.setHorizontalAlignment(Element.ALIGN_CENTER);
        table1.addCell(c3);
        c3 = new PdfPCell(new Phrase("N2 Pressure",catFont1));
        c3.setHorizontalAlignment(Element.ALIGN_CENTER);
        table1.addCell(c3);
        c3 = new PdfPCell(new Phrase("Pump IS",catFont1));
        c3.setHorizontalAlignment(Element.ALIGN_CENTER);
        table1.addCell(c3);
        c3 = new PdfPCell(new Phrase("Disch Pressure",catFont1));
        c3.setHorizontalAlignment(Element.ALIGN_CENTER);
        table1.addCell(c3);
        c3 = new PdfPCell(new Phrase("Flow Thru Ion Exchanger",catFont1));
        c3.setHorizontalAlignment(Element.ALIGN_CENTER);
        table1.addCell(c3);
        c3 = new PdfPCell(new Phrase("Main Ckt Conductivity",catFont1));
        c3.setHorizontalAlignment(Element.ALIGN_CENTER);
        table1.addCell(c3);
        c3 = new PdfPCell(new Phrase("Cooler IS",catFont1));
        c3.setHorizontalAlignment(Element.ALIGN_CENTER);
        table1.addCell(c3);
        c3 = new PdfPCell(new Phrase("Ctr O/L PW Temp",catFont1));
        c3.setHorizontalAlignment(Element.ALIGN_CENTER);
        table1.addCell(c3);
        table1.setHeaderRows(1);
        table1.addCell(mSharedPreferences.getString(Constants.turbineeightprimarywater[0],""));
        table1.addCell(mSharedPreferences.getString(Constants.turbineeightprimarywater[1],""));
        table1.addCell(mSharedPreferences.getString(Constants.turbineeightprimarywater[2],""));
        table1.addCell(mSharedPreferences.getString(Constants.turbineeightprimarywater[3],""));
        table1.addCell(mSharedPreferences.getString(Constants.turbineeightprimarywater[4],""));
        table1.addCell(mSharedPreferences.getString(Constants.turbineeightprimarywater[5],""));
        table1.addCell(mSharedPreferences.getString(Constants.turbineeightprimarywater[6],""));
        table1.addCell(mSharedPreferences.getString(Constants.turbineeightprimarywater[7],""));
        Paragraph paragraph2=new Paragraph();
        addEmptyLine(paragraph2,2);
        document.add(table1);
        document.add(paragraph2);

        Paragraph paragraph3=new Paragraph();
        paragraph3.add(new Paragraph("Generator Parameters",titleFont));
        addEmptyLine(paragraph3,1);
        document.add(paragraph3);
        PdfPTable table2=new PdfPTable(6);
        PdfPCell c4 = new PdfPCell(new Phrase("H2 Drier I/S",catFont1));
        c4.setHorizontalAlignment(Element.ALIGN_CENTER);
        table2.addCell(c4);
        c4 = new PdfPCell(new Phrase("Drier I/L Temp",catFont1));
        c4.setHorizontalAlignment(Element.ALIGN_CENTER);
        table2.addCell(c4);
        c4 = new PdfPCell(new Phrase("Drier O/L Temp",catFont1));
        c4.setHorizontalAlignment(Element.ALIGN_CENTER);
        table2.addCell(c4);
        c4 = new PdfPCell(new Phrase("Seal Oil DP TE/EE",catFont1));
        c4.setHorizontalAlignment(Element.ALIGN_CENTER);
        table2.addCell(c4);
        c4 = new PdfPCell(new Phrase("LLD TE/GC/EE",catFont1));
        c4.setHorizontalAlignment(Element.ALIGN_CENTER);
        table2.addCell(c4);
        c4 = new PdfPCell(new Phrase("Bus Duct/GCB Air Pressure",catFont1));
        c4.setHorizontalAlignment(Element.ALIGN_CENTER);
        table2.addCell(c4);
        table2.setHeaderRows(1);
        table2.addCell(mSharedPreferences.getString(Constants.turbineeightgeneratorparameters[0],""));
        table2.addCell(mSharedPreferences.getString(Constants.turbineeightgeneratorparameters[1],""));
        table2.addCell(mSharedPreferences.getString(Constants.turbineeightgeneratorparameters[2],""));
        table2.addCell(mSharedPreferences.getString(Constants.turbineeightgeneratorparameters[3],""));
        table2.addCell(mSharedPreferences.getString(Constants.turbineeightgeneratorparameters[4],""));
        table2.addCell(mSharedPreferences.getString(Constants.turbineeightgeneratorparameters[5],""));
        Paragraph paragraph4=new Paragraph();
        addEmptyLine(paragraph4,2);
        document.add(table2);
        document.add(paragraph4);

        Paragraph paragraph5=new Paragraph();
        paragraph5.add(new Paragraph("Turbine Oil System",titleFont));
        addEmptyLine(paragraph5,1);
        document.add(paragraph5);
        PdfPTable table3=new PdfPTable(9);
        PdfPCell c5 = new PdfPCell(new Phrase("Tank Level",catFont1));
        c5.setHorizontalAlignment(Element.ALIGN_CENTER);
        table3.addCell(c5);
        c5 = new PdfPCell(new Phrase("Cooler IS",catFont1));
        c5.setHorizontalAlignment(Element.ALIGN_CENTER);
        table3.addCell(c5);
        c5 = new PdfPCell(new Phrase("Cooler OL Temp",catFont1));
        c5.setHorizontalAlignment(Element.ALIGN_CENTER);
        table3.addCell(c5);
        c5 = new PdfPCell(new Phrase("V E Fan I/S",catFont1));
        c5.setHorizontalAlignment(Element.ALIGN_CENTER);
        table3.addCell(c5);
        c5 = new PdfPCell(new Phrase("MOT Filter I/S",catFont1));
        c5.setHorizontalAlignment(Element.ALIGN_CENTER);
        table3.addCell(c5);
        c5 = new PdfPCell(new Phrase("MOT Filter DP",catFont1));
        c5.setHorizontalAlignment(Element.ALIGN_CENTER);
        table3.addCell(c5);
        c5 = new PdfPCell(new Phrase("IPCV-1 Filter IS/DP",catFont1));
        c5.setHorizontalAlignment(Element.ALIGN_CENTER);
        table3.addCell(c5);
        c5 = new PdfPCell(new Phrase("HPCV-1 Filter IS/DP",catFont1));
        c5.setHorizontalAlignment(Element.ALIGN_CENTER);
        table3.addCell(c5);
        c5 = new PdfPCell(new Phrase("HPCV-2 Filter IS/DP",catFont1));
        c5.setHorizontalAlignment(Element.ALIGN_CENTER);
        table3.addCell(c5);
        table3.setHeaderRows(1);
        table3.addCell(mSharedPreferences.getString(Constants.turbineeightturbineoil[0],""));
        table3.addCell(mSharedPreferences.getString(Constants.turbineeightturbineoil[1],""));
        table3.addCell(mSharedPreferences.getString(Constants.turbineeightturbineoil[2],""));
        table3.addCell(mSharedPreferences.getString(Constants.turbineeightturbineoil[3],""));
        table3.addCell(mSharedPreferences.getString(Constants.turbineeightturbineoil[4],""));
        table3.addCell(mSharedPreferences.getString(Constants.turbineeightturbineoil[5],""));
        table3.addCell(mSharedPreferences.getString(Constants.turbineeightturbineoil[6],""));
        table3.addCell(mSharedPreferences.getString(Constants.turbineeightturbineoil[7],""));
        table3.addCell(mSharedPreferences.getString(Constants.turbineeightturbineoil[8],""));
        Paragraph paragraph6=new Paragraph();
        addEmptyLine(paragraph6,2);
        document.add(table3);
        document.add(paragraph6);

        Paragraph paragraph7=new Paragraph();
        paragraph7.add(new Paragraph("Other Oil System",titleFont));
        addEmptyLine(paragraph7,1);
        document.add(paragraph7);
        PdfPTable table4=new PdfPTable(7);
        PdfPCell c6 = new PdfPCell(new Phrase("Spray Man VV",catFont1));
        c6.setHorizontalAlignment(Element.ALIGN_CENTER);
        table4.addCell(c6);
        c6 = new PdfPCell(new Phrase("BP1 Oil Lvl/Oil Pressure",catFont1));
        c6.setHorizontalAlignment(Element.ALIGN_CENTER);
        table4.addCell(c6);
        c6 = new PdfPCell(new Phrase("BP2 Oil Lvl/Oil Pressure",catFont1));
        c6.setHorizontalAlignment(Element.ALIGN_CENTER);
        table4.addCell(c6);
        c6 = new PdfPCell(new Phrase("Seal Steam CV",catFont1));
        c6.setHorizontalAlignment(Element.ALIGN_CENTER);
        table4.addCell(c6);
        c6 = new PdfPCell(new Phrase("Leak Steam CV",catFont1));
        c6.setHorizontalAlignment(Element.ALIGN_CENTER);
        table4.addCell(c6);
        c6 = new PdfPCell(new Phrase("Vacuum Breaker",catFont1));
        c6.setHorizontalAlignment(Element.ALIGN_CENTER);
        table4.addCell(c6);
        c6 = new PdfPCell(new Phrase("HP Evac Valve",catFont1));
        c6.setHorizontalAlignment(Element.ALIGN_CENTER);
        table4.addCell(c6);
        table4.setHeaderRows(1);
        table4.addCell(mSharedPreferences.getString(Constants.turbineeightotheroilsystem[0],""));
        table4.addCell(mSharedPreferences.getString(Constants.turbineeightotheroilsystem[1],""));
        table4.addCell(mSharedPreferences.getString(Constants.turbineeightotheroilsystem[2],""));
        table4.addCell(mSharedPreferences.getString(Constants.turbineeightotheroilsystem[3],""));
        table4.addCell(mSharedPreferences.getString(Constants.turbineeightotheroilsystem[4],""));
        table4.addCell(mSharedPreferences.getString(Constants.turbineeightotheroilsystem[5],""));
        table4.addCell(mSharedPreferences.getString(Constants.turbineeightotheroilsystem[6],""));
        Paragraph paragraph8=new Paragraph();
        addEmptyLine(paragraph8,2);
        document.add(table4);
        document.add(paragraph8);

        Paragraph paragraph9=new Paragraph();
        paragraph9.add(new Paragraph("MOT Centrifuge",titleFont));
        addEmptyLine(paragraph9,1);
        document.add(paragraph9);
        PdfPTable table5=new PdfPTable(6);
        PdfPCell c7 = new PdfPCell(new Phrase("Water Level",catFont1));
        c7.setHorizontalAlignment(Element.ALIGN_CENTER);
        table5.addCell(c7);
        c7 = new PdfPCell(new Phrase("Water Temp",catFont1));
        c7.setHorizontalAlignment(Element.ALIGN_CENTER);
        table5.addCell(c7);
        c7 = new PdfPCell(new Phrase("Gear Box Oil Lvl",catFont1));
        c7.setHorizontalAlignment(Element.ALIGN_CENTER);
        table5.addCell(c7);
        c7 = new PdfPCell(new Phrase("CF Sucn Flow",catFont1));
        c7.setHorizontalAlignment(Element.ALIGN_CENTER);
        table5.addCell(c7);
        c7 = new PdfPCell(new Phrase("Heater I/S",catFont1));
        c7.setHorizontalAlignment(Element.ALIGN_CENTER);
        table5.addCell(c7);
        c7 = new PdfPCell(new Phrase("Booster Pump I/S",catFont1));
        c7.setHorizontalAlignment(Element.ALIGN_CENTER);
        table5.addCell(c7);
        table5.setHeaderRows(1);
        table5.addCell(mSharedPreferences.getString(Constants.turbineeightotheroilsystem[7],""));
        table5.addCell(mSharedPreferences.getString(Constants.turbineeightotheroilsystem[8],""));
        table5.addCell(mSharedPreferences.getString(Constants.turbineeightotheroilsystem[9],""));
        table5.addCell(mSharedPreferences.getString(Constants.turbineeightotheroilsystem[10],""));
        table5.addCell(mSharedPreferences.getString(Constants.turbineeightotheroilsystem[11],""));
        table5.addCell(mSharedPreferences.getString(Constants.turbineeightotheroilsystem[12],""));
        Paragraph paragraph10=new Paragraph();
        addEmptyLine(paragraph10,2);
        document.add(table5);
        document.add(paragraph10);

        Paragraph paragraph11=new Paragraph();
        paragraph11.add(new Paragraph("MDBFP",titleFont));
        addEmptyLine(paragraph11,1);
        document.add(paragraph11);
        PdfPTable table6=new PdfPTable(3);
        PdfPCell c8 = new PdfPCell(new Phrase("HC Tank Level",catFont1));
        c8.setHorizontalAlignment(Element.ALIGN_CENTER);
        table6.addCell(c8);
        c8 = new PdfPCell(new Phrase("LO Filter IS",catFont1));
        c8.setHorizontalAlignment(Element.ALIGN_CENTER);
        table6.addCell(c8);
        c8 = new PdfPCell(new Phrase("LO Filter DP",catFont1));
        c8.setHorizontalAlignment(Element.ALIGN_CENTER);
        table6.addCell(c8);
        table6.setHeaderRows(1);
        table6.addCell(mSharedPreferences.getString(Constants.turbineeightmdbfp[0],""));
        table6.addCell(mSharedPreferences.getString(Constants.turbineeightmdbfp[1],""));
        table6.addCell(mSharedPreferences.getString(Constants.turbineeightmdbfp[2],""));
        Paragraph paragraph12=new Paragraph();
        addEmptyLine(paragraph12,2);
        document.add(table6);
        document.add(paragraph12);

        Paragraph paragraph13=new Paragraph();
        paragraph13.add(new Paragraph("Turbine CF Pressures",titleFont));
        paragraph13.add(new Paragraph("Control Valve Positions"));
        addEmptyLine(paragraph13,1);
        document.add(paragraph13);
        PdfPTable table7=new PdfPTable(4);
        PdfPCell c9 = new PdfPCell(new Phrase("HPCV-1",catFont1));
        c9.setHorizontalAlignment(Element.ALIGN_CENTER);
        table7.addCell(c9);
        c9 = new PdfPCell(new Phrase("HPCV-2",catFont1));
        c9.setHorizontalAlignment(Element.ALIGN_CENTER);
        table7.addCell(c9);
        c9 = new PdfPCell(new Phrase("HPCV-1",catFont1));
        c9.setHorizontalAlignment(Element.ALIGN_CENTER);
        table7.addCell(c9);
        c9 = new PdfPCell(new Phrase("IPCV-2",catFont1));
        c9.setHorizontalAlignment(Element.ALIGN_CENTER);
        table7.addCell(c9);
        table7.setHeaderRows(1);
        table7.addCell(mSharedPreferences.getString(Constants.turbineeightturbinecf[0],""));
        table7.addCell(mSharedPreferences.getString(Constants.turbineeightturbinecf[1],""));
        table7.addCell(mSharedPreferences.getString(Constants.turbineeightturbinecf[2],""));
        table7.addCell(mSharedPreferences.getString(Constants.turbineeightturbinecf[3],""));
        document.add(table7);
        document.add(paragraph12);

        Paragraph paragraph14=new Paragraph();
        paragraph14.add(new Paragraph("Remarks",titleFont));
        addEmptyLine(paragraph14,1);
        paragraph14.add(new Paragraph(mSharedPreferences.getString(Constants.remarksturbineeightmeter,"")));
        document.add(paragraph14);

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
