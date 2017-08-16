package org.gripp.android.gripp.fragments.Boiler_ZeroFloor_Operator.Boiler_FeederFloor_Operator;


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

public class Fragment_BoilerZero_Shift_Initial_Detail extends BaseFragment {
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

    public static Fragment_BoilerZero_Shift_Initial_Detail newInstance(){
        return new Fragment_BoilerZero_Shift_Initial_Detail();
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
        dest=roota+"/boilerzero";
        String desta=dest+"/"+"boilerzero"+mSharedPreferences.getString(Constants.unit,"unit1")+initial_shift.toLowerCase()+findGroup().toLowerCase()+iday+imonth+iyear+".pdf";
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

    public void addTitlePage(Document document) throws DocumentException {
        Font catFont = new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.BOLD);
        Font catFont1 = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD);
        Font titleFont = new Font(Font.FontFamily.TIMES_ROMAN, 22, Font.BOLD
                | Font.UNDERLINE, BaseColor.GRAY);
        Font smallBold = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD);
        Font normal = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL);
        Paragraph paragraph = new Paragraph();
        addEmptyLine(paragraph, 1);
        paragraph.add(new Paragraph("Boiler Zero Meter", titleFont));
        addEmptyLine(paragraph, 1);
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
        Paragraph paragraph1 = new Paragraph();
        addEmptyLine(paragraph1, 2);
        document.add(table);
        document.add(paragraph1);

        PdfPTable table1=new PdfPTable(11);
        PdfPCell c2 = new PdfPCell(new Phrase("Coal Mill s",catFont1));
        c2.setColspan(2);
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
        c2 = new PdfPCell(new Phrase("Tank lvl/Temp"));
        c2.setColspan(2);
        table1.addCell(c2);
        table1.addCell(mSharedPreferences.getString(Constants.tlt_A,""));
        table1.addCell(mSharedPreferences.getString(Constants.tlt_B,""));
        table1.addCell(mSharedPreferences.getString(Constants.tlt_C,""));
        table1.addCell(mSharedPreferences.getString(Constants.tlt_D,""));
        table1.addCell(mSharedPreferences.getString(Constants.tlt_E,""));
        table1.addCell(mSharedPreferences.getString(Constants.tlt_F,""));
        table1.addCell(mSharedPreferences.getString(Constants.tlt_G,""));
        table1.addCell(mSharedPreferences.getString(Constants.tlt_H,""));
        table1.addCell(mSharedPreferences.getString(Constants.tlt_J,""));
        table1.addCell(mSharedPreferences.getString(Constants.tlt_K,""));
        c2 = new PdfPCell(new Phrase("LOP i/s"));
        c2.setColspan(2);
        table1.addCell(c2);
        table1.addCell(mSharedPreferences.getString(Constants.lopis_A,""));
        table1.addCell(mSharedPreferences.getString(Constants.lopis_B,""));
        table1.addCell(mSharedPreferences.getString(Constants.lopis_C,""));
        table1.addCell(mSharedPreferences.getString(Constants.lopis_D,""));
        table1.addCell(mSharedPreferences.getString(Constants.lopis_E,""));
        table1.addCell(mSharedPreferences.getString(Constants.lopis_F,""));
        table1.addCell(mSharedPreferences.getString(Constants.lopis_G,""));
        table1.addCell(mSharedPreferences.getString(Constants.lopis_H,""));
        table1.addCell(mSharedPreferences.getString(Constants.lopis_J,""));
        table1.addCell(mSharedPreferences.getString(Constants.lopis_K,""));
        c2 = new PdfPCell(new Phrase("Lub oil Pr."));
        c2.setColspan(2);
        table1.addCell(c2);
        table1.addCell(mSharedPreferences.getString(Constants.lopr_A,""));
        table1.addCell(mSharedPreferences.getString(Constants.lopr_B,""));
        table1.addCell(mSharedPreferences.getString(Constants.lopr_C,""));
        table1.addCell(mSharedPreferences.getString(Constants.lopr_D,""));
        table1.addCell(mSharedPreferences.getString(Constants.lopr_E,""));
        table1.addCell(mSharedPreferences.getString(Constants.lopr_F,""));
        table1.addCell(mSharedPreferences.getString(Constants.lopr_G,""));
        table1.addCell(mSharedPreferences.getString(Constants.lopr_H,""));
        table1.addCell(mSharedPreferences.getString(Constants.lopr_J,""));
        table1.addCell(mSharedPreferences.getString(Constants.lopr_K,""));
        c2 = new PdfPCell(new Phrase("Filter i/s"));
        c2.setColspan(2);
        table1.addCell(c2);
        table1.addCell(mSharedPreferences.getString(Constants.fis_A,""));
        table1.addCell(mSharedPreferences.getString(Constants.fis_B,""));
        table1.addCell(mSharedPreferences.getString(Constants.fis_C,""));
        table1.addCell(mSharedPreferences.getString(Constants.fis_D,""));
        table1.addCell(mSharedPreferences.getString(Constants.fis_E,""));
        table1.addCell(mSharedPreferences.getString(Constants.fis_F,""));
        table1.addCell(mSharedPreferences.getString(Constants.fis_G,""));
        table1.addCell(mSharedPreferences.getString(Constants.fis_H,""));
        table1.addCell(mSharedPreferences.getString(Constants.fis_J,""));
        table1.addCell(mSharedPreferences.getString(Constants.fis_K,""));
        c2 = new PdfPCell(new Phrase("Cooler i/s"));
        c2.setColspan(2);
        table1.addCell(c2);
        table1.addCell(mSharedPreferences.getString(Constants.cis_A,""));
        table1.addCell(mSharedPreferences.getString(Constants.cis_B,""));
        table1.addCell(mSharedPreferences.getString(Constants.cis_C,""));
        table1.addCell(mSharedPreferences.getString(Constants.cis_D,""));
        table1.addCell(mSharedPreferences.getString(Constants.cis_E,""));
        table1.addCell(mSharedPreferences.getString(Constants.cis_F,""));
        table1.addCell(mSharedPreferences.getString(Constants.cis_G,""));
        table1.addCell(mSharedPreferences.getString(Constants.cis_H,""));
        table1.addCell(mSharedPreferences.getString(Constants.cis_J,""));
        table1.addCell(mSharedPreferences.getString(Constants.cis_K,""));
        c2 = new PdfPCell(new Phrase("Clr o/l oil temp"));
        c2.setColspan(2);
        table1.addCell(c2);
        table1.addCell(mSharedPreferences.getString(Constants.coot_A,""));
        table1.addCell(mSharedPreferences.getString(Constants.coot_B,""));
        table1.addCell(mSharedPreferences.getString(Constants.coot_C,""));
        table1.addCell(mSharedPreferences.getString(Constants.coot_D,""));
        table1.addCell(mSharedPreferences.getString(Constants.coot_E,""));
        table1.addCell(mSharedPreferences.getString(Constants.coot_F,""));
        table1.addCell(mSharedPreferences.getString(Constants.coot_G,""));
        table1.addCell(mSharedPreferences.getString(Constants.coot_H,""));
        table1.addCell(mSharedPreferences.getString(Constants.coot_J,""));
        table1.addCell(mSharedPreferences.getString(Constants.coot_K,""));
        c2 = new PdfPCell(new Phrase("Pr aft Filter"));
        c2.setColspan(2);
        table1.addCell(c2);
        table1.addCell(mSharedPreferences.getString(Constants.pafilter_A,""));
        table1.addCell(mSharedPreferences.getString(Constants.pafilter_B,""));
        table1.addCell(mSharedPreferences.getString(Constants.pafilter_C,""));
        table1.addCell(mSharedPreferences.getString(Constants.pafilter_D,""));
        table1.addCell(mSharedPreferences.getString(Constants.pafilter_E,""));
        table1.addCell(mSharedPreferences.getString(Constants.pafilter_F,""));
        table1.addCell(mSharedPreferences.getString(Constants.pafilter_G,""));
        table1.addCell(mSharedPreferences.getString(Constants.pafilter_H,""));
        table1.addCell(mSharedPreferences.getString(Constants.pafilter_J,""));
        table1.addCell(mSharedPreferences.getString(Constants.pafilter_K,""));
        c2 = new PdfPCell(new Phrase("Pr aft Cooler"));
        c2.setColspan(2);
        table1.addCell(c2);
        table1.addCell(mSharedPreferences.getString(Constants.pacooler_A,""));
        table1.addCell(mSharedPreferences.getString(Constants.pacooler_B,""));
        table1.addCell(mSharedPreferences.getString(Constants.pacooler_C,""));
        table1.addCell(mSharedPreferences.getString(Constants.pacooler_D,""));
        table1.addCell(mSharedPreferences.getString(Constants.pacooler_E,""));
        table1.addCell(mSharedPreferences.getString(Constants.pacooler_F,""));
        table1.addCell(mSharedPreferences.getString(Constants.pacooler_G,""));
        table1.addCell(mSharedPreferences.getString(Constants.pacooler_H,""));
        table1.addCell(mSharedPreferences.getString(Constants.pacooler_J,""));
        table1.addCell(mSharedPreferences.getString(Constants.pacooler_K,""));
        c2 = new PdfPCell(new Phrase("Mill Rejection"));
        c2.setColspan(2);
        table1.addCell(c2);
        table1.addCell(mSharedPreferences.getString(Constants.mrejection_A,""));
        table1.addCell(mSharedPreferences.getString(Constants.mrejection_B,""));
        table1.addCell(mSharedPreferences.getString(Constants.mrejection_C,""));
        table1.addCell(mSharedPreferences.getString(Constants.mrejection_D,""));
        table1.addCell(mSharedPreferences.getString(Constants.mrejection_E,""));
        table1.addCell(mSharedPreferences.getString(Constants.mrejection_F,""));
        table1.addCell(mSharedPreferences.getString(Constants.mrejection_G,""));
        table1.addCell(mSharedPreferences.getString(Constants.mrejection_H,""));
        table1.addCell(mSharedPreferences.getString(Constants.mrejection_J,""));
        table1.addCell(mSharedPreferences.getString(Constants.mrejection_K,""));
        c2 = new PdfPCell(new Phrase("Reject Gate"));
        c2.setColspan(2);
        table1.addCell(c2);
        table1.addCell(mSharedPreferences.getString(Constants.rgate_A,""));
        table1.addCell(mSharedPreferences.getString(Constants.rgate_B,""));
        table1.addCell(mSharedPreferences.getString(Constants.rgate_C,""));
        table1.addCell(mSharedPreferences.getString(Constants.rgate_D,""));
        table1.addCell(mSharedPreferences.getString(Constants.rgate_E,""));
        table1.addCell(mSharedPreferences.getString(Constants.rgate_F,""));
        table1.addCell(mSharedPreferences.getString(Constants.rgate_G,""));
        table1.addCell(mSharedPreferences.getString(Constants.rgate_H,""));
        table1.addCell(mSharedPreferences.getString(Constants.rgate_J,""));
        table1.addCell(mSharedPreferences.getString(Constants.rgate_K,""));
        Paragraph paragraph2=new Paragraph();
        addEmptyLine(paragraph2,2);
        document.add(table1);
        document.add(paragraph2);

        Paragraph paragraph3=new Paragraph();
        paragraph3.add(new Paragraph("FD FAN",titleFont));
        addEmptyLine(paragraph3,1);
        document.add(paragraph3);
        PdfPTable table2=new PdfPTable(10);
        PdfPCell c3 = new PdfPCell(new Phrase("",catFont1));
        c3.setHorizontalAlignment(Element.ALIGN_CENTER);
        table2.addCell(c3);
        c3 = new PdfPCell(new Phrase("Oil Level",catFont1));
        c3.setHorizontalAlignment(Element.ALIGN_CENTER);
        table2.addCell(c3);
        c3 = new PdfPCell(new Phrase("Oil Temp",catFont1));
        c3.setHorizontalAlignment(Element.ALIGN_CENTER);
        table2.addCell(c3);
        c3 = new PdfPCell(new Phrase("LOP I/S",catFont1));
        c3.setHorizontalAlignment(Element.ALIGN_CENTER);
        table2.addCell(c3);
        c3 = new PdfPCell(new Phrase("LOP Disch. Pr",catFont1));
        c3.setHorizontalAlignment(Element.ALIGN_CENTER);
        table2.addCell(c3);
        c3 = new PdfPCell(new Phrase("DP Filter",catFont1));
        c3.setHorizontalAlignment(Element.ALIGN_CENTER);
        table2.addCell(c3);
        c3 = new PdfPCell(new Phrase("LO Supply hdr pr",catFont1));
        c3.setHorizontalAlignment(Element.ALIGN_CENTER);
        table2.addCell(c3);
        c3 = new PdfPCell(new Phrase("Cont. Oil Supply hdr Pr",catFont1));
        c3.setHorizontalAlignment(Element.ALIGN_CENTER);
        table2.addCell(c3);
        c3 = new PdfPCell(new Phrase("Cooler i/s",catFont1));
        c3.setHorizontalAlignment(Element.ALIGN_CENTER);
        table2.addCell(c3);
        c3 = new PdfPCell(new Phrase("Filter i/s",catFont1));
        c3.setHorizontalAlignment(Element.ALIGN_CENTER);
        table2.addCell(c3);
        table2.setHeaderRows(1);
        table2.addCell("FD FAN-A");
        table2.addCell(mSharedPreferences.getString(Constants.fdfan_A_oillevel,""));
        table2.addCell(mSharedPreferences.getString(Constants.fdfan_A_oiltemp,""));
        table2.addCell(mSharedPreferences.getString(Constants.fdfan_A_lopis,""));
        table2.addCell(mSharedPreferences.getString(Constants.fdfan_A_lop_discharge_pressure,""));
        table2.addCell(mSharedPreferences.getString(Constants.fdfan_A_dp_filter,""));
        table2.addCell(mSharedPreferences.getString(Constants.fdfan_A_lo_supply_hdr_pr,""));
        table2.addCell(mSharedPreferences.getString(Constants.fdfan_A_contoilsupplyhdrpr,""));
        table2.addCell(mSharedPreferences.getString(Constants.fdfan_A_cooleris,""));
        table2.addCell(mSharedPreferences.getString(Constants.fdfan_A_filteris,""));
        table2.addCell("FD FAN-B");
        table2.addCell(mSharedPreferences.getString(Constants.fdfan_B_oillevel,""));
        table2.addCell(mSharedPreferences.getString(Constants.fdfan_B_oiltemp,""));
        table2.addCell(mSharedPreferences.getString(Constants.fdfan_B_lopis,""));
        table2.addCell(mSharedPreferences.getString(Constants.fdfan_B_lop_discharge_pressure,""));
        table2.addCell(mSharedPreferences.getString(Constants.fdfan_B_dp_filter,""));
        table2.addCell(mSharedPreferences.getString(Constants.fdfan_B_lo_supply_hdr_pr,""));
        table2.addCell(mSharedPreferences.getString(Constants.fdfan_B_contoilsupplyhdrpr,""));
        table2.addCell(mSharedPreferences.getString(Constants.fdfan_B_cooleris,""));
        table2.addCell(mSharedPreferences.getString(Constants.fdfan_B_filteris,""));
        Paragraph paragraph4=new Paragraph();
        addEmptyLine(paragraph4,1);
        document.add(table2);
        document.add(paragraph4);

        PdfPTable table3=new PdfPTable(10);
        PdfPCell c4 = new PdfPCell(new Phrase("",catFont1));
        c4.setHorizontalAlignment(Element.ALIGN_CENTER);
        table3.addCell(c4);
        c4 = new PdfPCell(new Phrase("Oil Return Flow",catFont1));
        c4.setHorizontalAlignment(Element.ALIGN_CENTER);
        table3.addCell(c4);
        c4 = new PdfPCell(new Phrase("Temp at clr inlet",catFont1));
        c4.setHorizontalAlignment(Element.ALIGN_CENTER);
        table3.addCell(c4);
        c4 = new PdfPCell(new Phrase("Temp at clr outlet",catFont1));
        c4.setHorizontalAlignment(Element.ALIGN_CENTER);
        table3.addCell(c4);
        c4 = new PdfPCell(new Phrase("Motor brg temp DE",catFont1));
        c4.setHorizontalAlignment(Element.ALIGN_CENTER);
        table3.addCell(c4);
        c4 = new PdfPCell(new Phrase("Motor brg temp NDE",catFont1));
        c4.setHorizontalAlignment(Element.ALIGN_CENTER);
        table3.addCell(c4);
        c4 = new PdfPCell(new Phrase("fan brg temp DE(1)",catFont1));
        c4.setHorizontalAlignment(Element.ALIGN_CENTER);
        table3.addCell(c4);
        c4 = new PdfPCell(new Phrase("fan brg temp DE(2)",catFont1));
        c4.setHorizontalAlignment(Element.ALIGN_CENTER);
        table3.addCell(c4);
        c4 = new PdfPCell(new Phrase("Fan brg temp NDE",catFont1));
        c4.setHorizontalAlignment(Element.ALIGN_CENTER);
        table3.addCell(c4);
        c4 = new PdfPCell(new Phrase("Blade Pitch",catFont1));
        c4.setHorizontalAlignment(Element.ALIGN_CENTER);
        table3.addCell(c4);
        table3.addCell("FD FAN-A");
        table3.addCell(mSharedPreferences.getString(Constants.fdfan_A_oilreturnflow,""));
        table3.addCell(mSharedPreferences.getString(Constants.fdfan_A_dp_temp_at_clr_inlet,""));
        table3.addCell(mSharedPreferences.getString(Constants.fdfan_A_temp_at_clr_outlet,""));
        table3.addCell(mSharedPreferences.getString(Constants.fdfan_A_motor_brg_temp_DE,""));
        table3.addCell(mSharedPreferences.getString(Constants.fdfan_A_motor_brg_temp_NDE,""));
        table3.addCell(mSharedPreferences.getString(Constants.fdfan_A_fan_brg_temp_DE1,""));
        table3.addCell(mSharedPreferences.getString(Constants.fdfan_A_fan_brg_temp_DE2,""));
        table3.addCell(mSharedPreferences.getString(Constants.fdfan_A_fan_brg_temp_NDE,""));
        table3.addCell(mSharedPreferences.getString(Constants.fdfan_A_blade_pitch,""));
        table3.addCell("FD FAN-B");
        table3.addCell(mSharedPreferences.getString(Constants.fdfan_B_oilreturnflow,""));
        table3.addCell(mSharedPreferences.getString(Constants.fdfan_B_dp_temp_at_clr_inlet,""));
        table3.addCell(mSharedPreferences.getString(Constants.fdfan_B_temp_at_clr_outlet,""));
        table3.addCell(mSharedPreferences.getString(Constants.fdfan_B_motor_brg_temp_DE,""));
        table3.addCell(mSharedPreferences.getString(Constants.fdfan_B_motor_brg_temp_NDE,""));
        table3.addCell(mSharedPreferences.getString(Constants.fdfan_B_fan_brg_temp_DE1,""));
        table3.addCell(mSharedPreferences.getString(Constants.fdfan_B_fan_brg_temp_DE2,""));
        table3.addCell(mSharedPreferences.getString(Constants.fdfan_B_fan_brg_temp_NDE,""));
        table3.addCell(mSharedPreferences.getString(Constants.fdfan_B_blade_pitch,""));
        document.add(table3);
        document.add(paragraph2);

        Paragraph paragraph5=new Paragraph();
        paragraph5.add(new Paragraph("PA FAN",titleFont));
        addEmptyLine(paragraph5,1);
        document.add(paragraph5);
        PdfPTable table4=new PdfPTable(10);
        PdfPCell c5 = new PdfPCell(new Phrase("",catFont1));
        c5.setHorizontalAlignment(Element.ALIGN_CENTER);
        table4.addCell(c5);
        c5 = new PdfPCell(new Phrase("Oil Level",catFont1));
        c5.setHorizontalAlignment(Element.ALIGN_CENTER);
        table4.addCell(c5);
        c5 = new PdfPCell(new Phrase("Oil Temp",catFont1));
        c5.setHorizontalAlignment(Element.ALIGN_CENTER);
        table4.addCell(c5);
        c5 = new PdfPCell(new Phrase("LOP I/S",catFont1));
        c5.setHorizontalAlignment(Element.ALIGN_CENTER);
        table4.addCell(c5);
        c5 = new PdfPCell(new Phrase("LOP Disch. Pr",catFont1));
        c5.setHorizontalAlignment(Element.ALIGN_CENTER);
        table4.addCell(c5);
        c5 = new PdfPCell(new Phrase("DP Filter",catFont1));
        c3.setHorizontalAlignment(Element.ALIGN_CENTER);
        table4.addCell(c5);
        c5 = new PdfPCell(new Phrase("LO Supply hdr pr",catFont1));
        c5.setHorizontalAlignment(Element.ALIGN_CENTER);
        table4.addCell(c5);
        c5 = new PdfPCell(new Phrase("Cont. Oil Supply hdr Pr",catFont1));
        c5.setHorizontalAlignment(Element.ALIGN_CENTER);
        table4.addCell(c5);
        c5 = new PdfPCell(new Phrase("Cooler i/s",catFont1));
        c5.setHorizontalAlignment(Element.ALIGN_CENTER);
        table4.addCell(c5);
        c5 = new PdfPCell(new Phrase("Filter i/s",catFont1));
        c5.setHorizontalAlignment(Element.ALIGN_CENTER);
        table4.addCell(c5);
        table4.setHeaderRows(1);
        table4.addCell("PA FAN-A");
        table4.addCell(mSharedPreferences.getString(Constants.pafan_A_oillevel,""));
        table4.addCell(mSharedPreferences.getString(Constants.pafan_A_oiltemp,""));
        table4.addCell(mSharedPreferences.getString(Constants.pafan_A_lopis,""));
        table4.addCell(mSharedPreferences.getString(Constants.pafan_A_lop_discharge_pressure,""));
        table4.addCell(mSharedPreferences.getString(Constants.pafan_A_dp_filter,""));
        table4.addCell(mSharedPreferences.getString(Constants.pafan_A_lo_supply_hdr_pr,""));
        table4.addCell(mSharedPreferences.getString(Constants.pafan_A_contoilsupplyhdrpr,""));
        table4.addCell(mSharedPreferences.getString(Constants.pafan_A_cooleris,""));
        table4.addCell(mSharedPreferences.getString(Constants.pafan_A_filteris,""));
        table4.addCell("PA FAN-B");
        table4.addCell(mSharedPreferences.getString(Constants.pafan_B_oillevel,""));
        table4.addCell(mSharedPreferences.getString(Constants.pafan_B_oiltemp,""));
        table4.addCell(mSharedPreferences.getString(Constants.pafan_B_lopis,""));
        table4.addCell(mSharedPreferences.getString(Constants.pafan_B_lop_discharge_pressure,""));
        table4.addCell(mSharedPreferences.getString(Constants.pafan_B_dp_filter,""));
        table4.addCell(mSharedPreferences.getString(Constants.pafan_B_lo_supply_hdr_pr,""));
        table4.addCell(mSharedPreferences.getString(Constants.pafan_B_contoilsupplyhdrpr,""));
        table4.addCell(mSharedPreferences.getString(Constants.pafan_B_cooleris,""));
        table4.addCell(mSharedPreferences.getString(Constants.pafan_B_filteris,""));
        document.add(table4);
        document.add(paragraph4);

        PdfPTable table5=new PdfPTable(11);
        PdfPCell c6 = new PdfPCell(new Phrase("",catFont1));
        c6.setHorizontalAlignment(Element.ALIGN_CENTER);
        table5.addCell(c6);
        c6 = new PdfPCell(new Phrase("Oil Return Flow",catFont1));
        c6.setHorizontalAlignment(Element.ALIGN_CENTER);
        table5.addCell(c6);
        c6 = new PdfPCell(new Phrase("Temp at clr inlet",catFont1));
        c6.setHorizontalAlignment(Element.ALIGN_CENTER);
        table5.addCell(c6);
        c6 = new PdfPCell(new Phrase("Temp at clr outlet",catFont1));
        c6.setHorizontalAlignment(Element.ALIGN_CENTER);
        table5.addCell(c6);
        c6 = new PdfPCell(new Phrase("Motor brg temp DE",catFont1));
        c6.setHorizontalAlignment(Element.ALIGN_CENTER);
        table5.addCell(c6);
        c6 = new PdfPCell(new Phrase("Motor brg temp NDE",catFont1));
        c6.setHorizontalAlignment(Element.ALIGN_CENTER);
        table5.addCell(c6);
        c6 = new PdfPCell(new Phrase("fan brg temp DE",catFont1));
        c6.setHorizontalAlignment(Element.ALIGN_CENTER);
        table5.addCell(c6);
        c6 = new PdfPCell(new Phrase("fan brg temp NDE",catFont1));
        c6.setHorizontalAlignment(Element.ALIGN_CENTER);
        table5.addCell(c6);
        c6 = new PdfPCell(new Phrase("Fan Thrust Big-1",catFont1));
        c6.setHorizontalAlignment(Element.ALIGN_CENTER);
        table5.addCell(c6);
        c6 = new PdfPCell(new Phrase("Fan Thrust Big-2",catFont1));
        c6.setHorizontalAlignment(Element.ALIGN_CENTER);
        table5.addCell(c6);
        c6 = new PdfPCell(new Phrase("Blade Pitch",catFont1));
        c6.setHorizontalAlignment(Element.ALIGN_CENTER);
        table5.addCell(c6);
        table5.addCell("PA FAN-A");
        table5.addCell(mSharedPreferences.getString(Constants.pafan_A_oilreturnflow,""));
        table5.addCell(mSharedPreferences.getString(Constants.pafan_A_dp_temp_at_clr_inlet,""));
        table5.addCell(mSharedPreferences.getString(Constants.pafan_A_temp_at_clr_outlet,""));
        table5.addCell(mSharedPreferences.getString(Constants.pafan_A_motor_brg_temp_DE,""));
        table5.addCell(mSharedPreferences.getString(Constants.pafan_A_motor_brg_temp_NDE,""));
        table5.addCell(mSharedPreferences.getString(Constants.pafan_A_fan_brg_temp_DE,""));
        table5.addCell(mSharedPreferences.getString(Constants.pafan_A_fan_brg_temp_NDE,""));
        table5.addCell(mSharedPreferences.getString(Constants.pafan_A_fan_thrust_brg_1,""));
        table5.addCell(mSharedPreferences.getString(Constants.pafan_A_fan_thrust_brg_2,""));
        table5.addCell(mSharedPreferences.getString(Constants.pafan_A_blade_pitch,""));
        table5.addCell("PA FAN-B");
        table5.addCell(mSharedPreferences.getString(Constants.pafan_B_oilreturnflow,""));
        table5.addCell(mSharedPreferences.getString(Constants.pafan_B_dp_temp_at_clr_inlet,""));
        table5.addCell(mSharedPreferences.getString(Constants.pafan_B_temp_at_clr_outlet,""));
        table5.addCell(mSharedPreferences.getString(Constants.pafan_B_motor_brg_temp_DE,""));
        table5.addCell(mSharedPreferences.getString(Constants.pafan_B_motor_brg_temp_NDE,""));
        table5.addCell(mSharedPreferences.getString(Constants.pafan_B_fan_brg_temp_DE,""));
        table5.addCell(mSharedPreferences.getString(Constants.pafan_B_fan_brg_temp_NDE,""));
        table5.addCell(mSharedPreferences.getString(Constants.pafan_B_fan_thrust_brg_1,""));
        table5.addCell(mSharedPreferences.getString(Constants.pafan_B_fan_thrust_brg_2,""));
        table5.addCell(mSharedPreferences.getString(Constants.pafan_B_blade_pitch,""));
        document.add(table5);
        document.add(paragraph2);

        Paragraph paragraph6=new Paragraph();
        paragraph6.add(new Paragraph("ID FAN",titleFont));
        addEmptyLine(paragraph6,1);
        document.add(paragraph6);
        PdfPTable table6=new PdfPTable(10);
        PdfPCell c7 = new PdfPCell(new Phrase("",catFont1));
        c7.setHorizontalAlignment(Element.ALIGN_CENTER);
        table6.addCell(c7);
        c7 = new PdfPCell(new Phrase("Oil Level",catFont1));
        c5.setHorizontalAlignment(Element.ALIGN_CENTER);
        table6.addCell(c7);
        c7 = new PdfPCell(new Phrase("Oil Temp",catFont1));
        c7.setHorizontalAlignment(Element.ALIGN_CENTER);
        table6.addCell(c7);
        c7 = new PdfPCell(new Phrase("LOP I/S",catFont1));
        c7.setHorizontalAlignment(Element.ALIGN_CENTER);
        table6.addCell(c7);
        c7 = new PdfPCell(new Phrase("LOP Disch. Pr",catFont1));
        c7.setHorizontalAlignment(Element.ALIGN_CENTER);
        table6.addCell(c7);
        c7 = new PdfPCell(new Phrase("DP Filter",catFont1));
        c7.setHorizontalAlignment(Element.ALIGN_CENTER);
        table6.addCell(c7);
        c7 = new PdfPCell(new Phrase("LO Supply hdr pr",catFont1));
        c7.setHorizontalAlignment(Element.ALIGN_CENTER);
        table6.addCell(c7);
        c7 = new PdfPCell(new Phrase("Cont. Oil Supply hdr Pr",catFont1));
        c7.setHorizontalAlignment(Element.ALIGN_CENTER);
        table6.addCell(c7);
        c7 = new PdfPCell(new Phrase("Temp at clr inlet",catFont1));
        c7.setHorizontalAlignment(Element.ALIGN_CENTER);
        table6.addCell(c7);
        c7 = new PdfPCell(new Phrase("Temp at clr outlet",catFont1));
        c7.setHorizontalAlignment(Element.ALIGN_CENTER);
        table6.addCell(c7);
        table6.setHeaderRows(1);
        table6.addCell("ID FAN-A");
        table6.addCell(mSharedPreferences.getString(Constants.idfan_A_oillevel,""));
        table6.addCell(mSharedPreferences.getString(Constants.idfan_A_oiltemp,""));
        table6.addCell(mSharedPreferences.getString(Constants.idfan_A_lopis,""));
        table6.addCell(mSharedPreferences.getString(Constants.idfan_A_lop_discharge_pressure,""));
        table6.addCell(mSharedPreferences.getString(Constants.idfan_A_dp_filter,""));
        table6.addCell(mSharedPreferences.getString(Constants.idfan_A_lo_supply_hdr_pr,""));
        table6.addCell(mSharedPreferences.getString(Constants.idfan_A_contoilsupplyhdrpr,""));
        table6.addCell(mSharedPreferences.getString(Constants.idfan_A_temp_at_clr_inlet,""));
        table6.addCell(mSharedPreferences.getString(Constants.idfan_A_temp_at_clr_outlet,""));
        table6.addCell("ID FAN-B");
        table6.addCell(mSharedPreferences.getString(Constants.idfan_B_oillevel,""));
        table6.addCell(mSharedPreferences.getString(Constants.idfan_B_oiltemp,""));
        table6.addCell(mSharedPreferences.getString(Constants.idfan_B_lopis,""));
        table6.addCell(mSharedPreferences.getString(Constants.idfan_B_lop_discharge_pressure,""));
        table6.addCell(mSharedPreferences.getString(Constants.idfan_B_dp_filter,""));
        table6.addCell(mSharedPreferences.getString(Constants.idfan_B_lo_supply_hdr_pr,""));
        table6.addCell(mSharedPreferences.getString(Constants.idfan_B_contoilsupplyhdrpr,""));
        table6.addCell(mSharedPreferences.getString(Constants.idfan_B_temp_at_clr_inlet,""));
        table6.addCell(mSharedPreferences.getString(Constants.idfan_B_temp_at_clr_outlet,""));
        document.add(table6);
        document.add(paragraph4);

        PdfPTable table7=new PdfPTable(9);
        PdfPCell c8 = new PdfPCell(new Phrase("",catFont1));
        c8.setHorizontalAlignment(Element.ALIGN_CENTER);
        table7.addCell(c8);
        c8 = new PdfPCell(new Phrase("Motor brg temp DE",catFont1));
        c8.setHorizontalAlignment(Element.ALIGN_CENTER);
        table7.addCell(c8);
        c8 = new PdfPCell(new Phrase("Motor brg temp NDE",catFont1));
        c8.setHorizontalAlignment(Element.ALIGN_CENTER);
        table7.addCell(c8);
        c8 = new PdfPCell(new Phrase("Motor Clr CW Flow 1",catFont1));
        c8.setHorizontalAlignment(Element.ALIGN_CENTER);
        table7.addCell(c8);
        c8 = new PdfPCell(new Phrase("Motor Clr CW Flow 2",catFont1));
        c8.setHorizontalAlignment(Element.ALIGN_CENTER);
        table7.addCell(c8);
        c8 = new PdfPCell(new Phrase("Cold/Hot/Cold Air Temp",catFont1));
        c8.setHorizontalAlignment(Element.ALIGN_CENTER);
        table7.addCell(c8);
        c8 = new PdfPCell(new Phrase("fan brg temp DE",catFont1));
        c8.setHorizontalAlignment(Element.ALIGN_CENTER);
        table7.addCell(c8);
        c8 = new PdfPCell(new Phrase("fan brg temp NDE",catFont1));
        c8.setHorizontalAlignment(Element.ALIGN_CENTER);
        table7.addCell(c8);
        c8 = new PdfPCell(new Phrase("IGV Position",catFont1));
        c8.setHorizontalAlignment(Element.ALIGN_CENTER);
        table7.addCell(c8);
        table7.setHeaderRows(1);
        table7.addCell("ID FAN-A");
        table7.addCell(mSharedPreferences.getString(Constants.idfan_A_motor_brg_temp_DE,""));
        table7.addCell(mSharedPreferences.getString(Constants.idfan_A_motor_brg_temp_NDE,""));
        table7.addCell(mSharedPreferences.getString(Constants.idfan_A_motor_clr_CW_Flow_1,""));
        table7.addCell(mSharedPreferences.getString(Constants.idfan_A_motor_clr_CW_Flow_2,""));
        table7.addCell(mSharedPreferences.getString(Constants.idfan_A_cold_hot_cold_air_temp,""));
        table7.addCell(mSharedPreferences.getString(Constants.idfan_A_fan_brg_temp_DE,""));
        table7.addCell(mSharedPreferences.getString(Constants.idfan_A_fan_brg_temp_NDE,""));
        table7.addCell(mSharedPreferences.getString(Constants.idfan_A_igv_position,""));
        table7.addCell("ID FAN-B");
        table7.addCell(mSharedPreferences.getString(Constants.idfan_B_motor_brg_temp_DE,""));
        table7.addCell(mSharedPreferences.getString(Constants.idfan_B_motor_brg_temp_NDE,""));
        table7.addCell(mSharedPreferences.getString(Constants.idfan_B_motor_clr_CW_Flow_1,""));
        table7.addCell(mSharedPreferences.getString(Constants.idfan_B_motor_clr_CW_Flow_2,""));
        table7.addCell(mSharedPreferences.getString(Constants.idfan_B_cold_hot_cold_air_temp,""));
        table7.addCell(mSharedPreferences.getString(Constants.idfan_B_fan_brg_temp_DE,""));
        table7.addCell(mSharedPreferences.getString(Constants.idfan_B_fan_brg_temp_NDE,""));
        table7.addCell(mSharedPreferences.getString(Constants.idfan_B_igv_position,""));
        document.add(table7);
        document.add(paragraph2);

        Paragraph paragraph7=new Paragraph();
        paragraph7.add(new Paragraph("Remarks",titleFont));
        addEmptyLine(paragraph7,1);
        paragraph7.add(new Paragraph(mSharedPreferences.getString(Constants.remarksboilerzero,"")));
        document.add(paragraph7);

        
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

    private static void addEmptyLine(Paragraph paragraph, int number) {
        for (int i = 0; i < number; i++) {
            paragraph.add(new Paragraph(" "));
        }
    }
}
