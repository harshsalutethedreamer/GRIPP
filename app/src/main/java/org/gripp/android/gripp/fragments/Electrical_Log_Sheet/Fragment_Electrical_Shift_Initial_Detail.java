package org.gripp.android.gripp.fragments.Electrical_Log_Sheet;


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
import android.widget.Toast;

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

public class Fragment_Electrical_Shift_Initial_Detail extends BaseFragment {
    @BindView(R.id.fragment_initial_detail_date)
    TextView fragment_initial_detail_date;

    @BindView(R.id.fragment_initial_detail_shift)
    TextView fragment_initial_detail_shift;

    @BindView(R.id.fragment_initial_detail_group)
    TextView fragment_initial_detail_group;

    @BindView(R.id.initial_button)
    Button saveastext;

    @BindView(R.id.reset_button)
    Button resettext;

    String initial_date,initial_shift,initial_group,group_member_C,hname;
    int iyear,imonthadd;
    String iday,imonth;

    private Unbinder mUnbinder;
    public String dest;
    SimpleDateFormat df;

    public static Fragment_Electrical_Shift_Initial_Detail newInstance(){
        return new Fragment_Electrical_Shift_Initial_Detail();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView=inflater.inflate(R.layout.fragment_initial_detail,container,false);
        mUnbinder= ButterKnife.bind(this,rootView);

        saveastext.setVisibility(View.VISIBLE);
        resettext.setVisibility(View.VISIBLE);

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
        dest=roota+"/electrical";
        String desta=dest+"/"+"electrical_unit"+mSharedPreferences.getString(Constants.unit,"unit1")+initial_shift.toLowerCase()+findGroup().toLowerCase()+iday+imonth+iyear+".pdf";
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

    @OnClick(R.id.reset_button)
    public void onClickagain(){
        mSharedPreferences.edit().clear().commit();
        Toast.makeText(getActivity(),"Data Cleared Successfully",Toast.LENGTH_SHORT).show();
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
        paragraph.add(new Paragraph("Electrical Operator",titleFont));
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

        Paragraph paragraphz=new Paragraph();
        paragraphz.add(new Paragraph("DG SET",titleFont));
        addEmptyLine(paragraphz,1);
        document.add(paragraphz);
        PdfPTable tabley=new PdfPTable(3);
        PdfPCell cy = new PdfPCell(new Phrase("",catFont1));
        cy.setHorizontalAlignment(Element.ALIGN_CENTER);
        tabley.addCell(cy);
        cy = new PdfPCell(new Phrase("MAIN",catFont1));
        cy.setHorizontalAlignment(Element.ALIGN_CENTER);
        tabley.addCell(cy);
        cy = new PdfPCell(new Phrase("S/B",catFont1));
        cy.setHorizontalAlignment(Element.ALIGN_CENTER);
        tabley.addCell(cy);
        tabley.setHeaderRows(1);
        tabley.addCell("24 Chgr. volt/amps");
        tabley.addCell(mSharedPreferences.getString(Constants.electricaldgset[0],""));
        tabley.addCell(mSharedPreferences.getString(Constants.electricaldgset[1],""));
        tabley.addCell("Battery Current");
        tabley.addCell(mSharedPreferences.getString(Constants.electricaldgset[2],""));
        tabley.addCell(mSharedPreferences.getString(Constants.electricaldgset[3],""));
        tabley.addCell("220V Control Supply");
        tabley.addCell(mSharedPreferences.getString(Constants.electricaldgset[4],""));
        tabley.addCell(mSharedPreferences.getString(Constants.electricaldgset[5],""));
        tabley.addCell("Diesel Tank Level(Litres)");
        tabley.addCell(mSharedPreferences.getString(Constants.electricaldgset[6],""));
        tabley.addCell(mSharedPreferences.getString(Constants.electricaldgset[7],""));
        tabley.addCell("Coolant Level");
        tabley.addCell(mSharedPreferences.getString(Constants.electricaldgset[8],""));
        tabley.addCell(mSharedPreferences.getString(Constants.electricaldgset[9],""));
        tabley.addCell("Alternator Voltage(L-L)");
        tabley.addCell(mSharedPreferences.getString(Constants.electricaldgset[10],""));
        tabley.addCell(mSharedPreferences.getString(Constants.electricaldgset[11],""));
        tabley.addCell("AVR Duty Cycle%");
        tabley.addCell(mSharedPreferences.getString(Constants.electricaldgset[12],""));
        tabley.addCell(mSharedPreferences.getString(Constants.electricaldgset[13],""));
        tabley.addCell("Coolant Temp C");
        tabley.addCell(mSharedPreferences.getString(Constants.electricaldgset[14],""));
        tabley.addCell(mSharedPreferences.getString(Constants.electricaldgset[15],""));
        tabley.addCell("Oil Pressure(Kpa)");
        tabley.addCell(mSharedPreferences.getString(Constants.electricaldgset[16],""));
        tabley.addCell(mSharedPreferences.getString(Constants.electricaldgset[17],""));
        tabley.addCell("Oil Temp C");
        tabley.addCell(mSharedPreferences.getString(Constants.electricaldgset[18],""));
        tabley.addCell(mSharedPreferences.getString(Constants.electricaldgset[19],""));
        tabley.addCell("Engine Speed(rpm)");
        tabley.addCell(mSharedPreferences.getString(Constants.electricaldgset[20],""));
        tabley.addCell(mSharedPreferences.getString(Constants.electricaldgset[21],""));
        tabley.addCell("Governor Duty Cycle %");
        tabley.addCell(mSharedPreferences.getString(Constants.electricaldgset[22],""));
        tabley.addCell(mSharedPreferences.getString(Constants.electricaldgset[23],""));
        tabley.addCell("Temp Scanner C");
        tabley.addCell(mSharedPreferences.getString(Constants.electricaldgset[24],""));
        tabley.addCell(mSharedPreferences.getString(Constants.electricaldgset[25],""));
        Paragraph paragraphy=new Paragraph();
        addEmptyLine(paragraphy,2);
        document.add(tabley);
        document.add(paragraphy);

        Paragraph paragrapha=new Paragraph();
        paragrapha.add(new Paragraph("Transformers",titleFont));
        addEmptyLine(paragrapha,1);
        document.add(paragrapha);
        PdfPTable table1=new PdfPTable(8);
        PdfPCell c3 = new PdfPCell(new Phrase("Transformers",catFont1));
        c3.setHorizontalAlignment(Element.ALIGN_CENTER);
        table1.addCell(c3);
        c3 = new PdfPCell(new Phrase("GT R",catFont1));
        c3.setHorizontalAlignment(Element.ALIGN_CENTER);
        table1.addCell(c3);
        c3 = new PdfPCell(new Phrase("GT Y",catFont1));
        c3.setHorizontalAlignment(Element.ALIGN_CENTER);
        table1.addCell(c3);
        c3 = new PdfPCell(new Phrase("GT B",catFont1));
        c3.setHorizontalAlignment(Element.ALIGN_CENTER);
        table1.addCell(c3);
        c3 = new PdfPCell(new Phrase("UT",catFont1));
        c3.setHorizontalAlignment(Element.ALIGN_CENTER);
        table1.addCell(c3);
        c3 = new PdfPCell(new Phrase("UAT-A",catFont1));
        c3.setHorizontalAlignment(Element.ALIGN_CENTER);
        table1.addCell(c3);
        c3 = new PdfPCell(new Phrase("UAT-B",catFont1));
        c3.setHorizontalAlignment(Element.ALIGN_CENTER);
        table1.addCell(c3);
        c3 = new PdfPCell(new Phrase("ST",catFont1));
        c3.setHorizontalAlignment(Element.ALIGN_CENTER);
        table1.addCell(c3);
        table1.setHeaderRows(1);
        table1.addCell("WTI");
        table1.addCell(mSharedPreferences.getString(Constants.electricalgtphase[0],""));
        table1.addCell(mSharedPreferences.getString(Constants.electricalgtphase[1],""));
        table1.addCell(mSharedPreferences.getString(Constants.electricalgtphase[2],""));
        table1.addCell(mSharedPreferences.getString(Constants.electricaluttransformer[0],""));
        table1.addCell(mSharedPreferences.getString(Constants.electricaluttransformer[1],""));
        table1.addCell(mSharedPreferences.getString(Constants.electricaluttransformer[2],""));
        table1.addCell(mSharedPreferences.getString(Constants.electricaluttransformer[3],""));
        table1.addCell("OTI");
        table1.addCell(mSharedPreferences.getString(Constants.electricalgtphase[3],""));
        table1.addCell(mSharedPreferences.getString(Constants.electricalgtphase[4],""));
        table1.addCell(mSharedPreferences.getString(Constants.electricalgtphase[5],""));
        table1.addCell(mSharedPreferences.getString(Constants.electricaluttransformer[4],""));
        table1.addCell(mSharedPreferences.getString(Constants.electricaluttransformer[5],""));
        table1.addCell(mSharedPreferences.getString(Constants.electricaluttransformer[6],""));
        table1.addCell(mSharedPreferences.getString(Constants.electricaluttransformer[7],""));
        table1.addCell("Conservtr Oil Level");
        table1.addCell(mSharedPreferences.getString(Constants.electricalgtphase[6],""));
        table1.addCell(mSharedPreferences.getString(Constants.electricalgtphase[7],""));
        table1.addCell(mSharedPreferences.getString(Constants.electricalgtphase[8],""));
        table1.addCell(mSharedPreferences.getString(Constants.electricaluttransformer[8],""));
        table1.addCell(mSharedPreferences.getString(Constants.electricaluttransformer[9],""));
        table1.addCell(mSharedPreferences.getString(Constants.electricaluttransformer[10],""));
        table1.addCell(mSharedPreferences.getString(Constants.electricaluttransformer[11],""));
        table1.addCell("Fans&p/ps in service");
        table1.addCell(mSharedPreferences.getString(Constants.electricalgtphase[9],""));
        table1.addCell(mSharedPreferences.getString(Constants.electricalgtphase[10],""));
        table1.addCell(mSharedPreferences.getString(Constants.electricalgtphase[11],""));
        table1.addCell(mSharedPreferences.getString(Constants.electricaluttransformer[12],""));
        table1.addCell(mSharedPreferences.getString(Constants.electricaluttransformer[13],""));
        table1.addCell(mSharedPreferences.getString(Constants.electricaluttransformer[14],""));
        table1.addCell(mSharedPreferences.getString(Constants.electricaluttransformer[15],""));
        table1.addCell("Oil leakage if any");
        table1.addCell(mSharedPreferences.getString(Constants.electricalgtphase[12],""));
        table1.addCell(mSharedPreferences.getString(Constants.electricalgtphase[13],""));
        table1.addCell(mSharedPreferences.getString(Constants.electricalgtphase[14],""));
        table1.addCell(mSharedPreferences.getString(Constants.electricaluttransformer[16],""));
        table1.addCell(mSharedPreferences.getString(Constants.electricaluttransformer[17],""));
        table1.addCell(mSharedPreferences.getString(Constants.electricaluttransformer[18],""));
        table1.addCell(mSharedPreferences.getString(Constants.electricaluttransformer[19],""));

        table1.addCell("TAP Position");
        table1.addCell(mSharedPreferences.getString(Constants.electricalgtphase[15],""));
        table1.addCell(mSharedPreferences.getString(Constants.electricalgtphase[16],""));
        table1.addCell(mSharedPreferences.getString(Constants.electricalgtphase[17],""));
        table1.addCell(mSharedPreferences.getString(Constants.electricaluttransformer[20],""));
        table1.addCell(mSharedPreferences.getString(Constants.electricaluttransformer[21],""));
        table1.addCell(mSharedPreferences.getString(Constants.electricaluttransformer[22],""));
        table1.addCell(mSharedPreferences.getString(Constants.electricaluttransformer[23],""));
        table1.addCell("Silica gel color");
        table1.addCell(mSharedPreferences.getString(Constants.electricalgtphase[18],""));
        table1.addCell(mSharedPreferences.getString(Constants.electricalgtphase[19],""));
        table1.addCell(mSharedPreferences.getString(Constants.electricalgtphase[20],""));
        table1.addCell(mSharedPreferences.getString(Constants.electricaluttransformer[24],""));
        table1.addCell(mSharedPreferences.getString(Constants.electricaluttransformer[25],""));
        table1.addCell(mSharedPreferences.getString(Constants.electricaluttransformer[26],""));
        table1.addCell(mSharedPreferences.getString(Constants.electricaluttransformer[27],""));
        table1.addCell("Deluge v/v Open");
        table1.addCell(mSharedPreferences.getString(Constants.electricalgtphase[21],""));
        table1.addCell(mSharedPreferences.getString(Constants.electricalgtphase[22],""));
        table1.addCell(mSharedPreferences.getString(Constants.electricalgtphase[23],""));
        table1.addCell(mSharedPreferences.getString(Constants.electricaluttransformer[28],""));
        table1.addCell(mSharedPreferences.getString(Constants.electricaluttransformer[29],""));
        table1.addCell(mSharedPreferences.getString(Constants.electricaluttransformer[30],""));
        table1.addCell(mSharedPreferences.getString(Constants.electricaluttransformer[31],""));
        table1.addCell("Spray wtr pressure");
        table1.addCell(mSharedPreferences.getString(Constants.electricalgtphase[24],""));
        table1.addCell(mSharedPreferences.getString(Constants.electricalgtphase[25],""));
        table1.addCell(mSharedPreferences.getString(Constants.electricalgtphase[26],""));
        table1.addCell(mSharedPreferences.getString(Constants.electricaluttransformer[32],""));
        table1.addCell(mSharedPreferences.getString(Constants.electricaluttransformer[33],""));
        table1.addCell(mSharedPreferences.getString(Constants.electricaluttransformer[34],""));
        table1.addCell(mSharedPreferences.getString(Constants.electricaluttransformer[35],""));

        table1.addCell("Signal line pressure");
        table1.addCell(mSharedPreferences.getString(Constants.electricalgtphase[27],""));
        table1.addCell(mSharedPreferences.getString(Constants.electricalgtphase[28],""));
        table1.addCell(mSharedPreferences.getString(Constants.electricalgtphase[29],""));
        table1.addCell(mSharedPreferences.getString(Constants.electricaluttransformer[36],""));
        table1.addCell(mSharedPreferences.getString(Constants.electricaluttransformer[37],""));
        table1.addCell(mSharedPreferences.getString(Constants.electricaluttransformer[38],""));
        table1.addCell(mSharedPreferences.getString(Constants.electricaluttransformer[39],""));
        Paragraph paragraph2=new Paragraph();
        addEmptyLine(paragraph2,2);
        document.add(table1);
        document.add(paragraph2);

        Paragraph paragraph3=new Paragraph();
        paragraph3.add(new Paragraph("LT Transformers",titleFont));
        addEmptyLine(paragraph3,1);
        document.add(paragraph3);
        PdfPTable table2=new PdfPTable(4);
        PdfPCell c4 = new PdfPCell(new Phrase("LT Transformers",catFont1));
        c4.setHorizontalAlignment(Element.ALIGN_CENTER);
        table2.addCell(c4);
        c4 = new PdfPCell(new Phrase("WT-R",catFont1));
        c4.setHorizontalAlignment(Element.ALIGN_CENTER);
        table2.addCell(c4);
        c4 = new PdfPCell(new Phrase("WT-Y",catFont1));
        c4.setHorizontalAlignment(Element.ALIGN_CENTER);
        table2.addCell(c4);
        c4 = new PdfPCell(new Phrase("WT-B",catFont1));
        c4.setHorizontalAlignment(Element.ALIGN_CENTER);
        table2.addCell(c4);
        table2.setHeaderRows(1);
        table2.addCell("UST-A");
        table2.addCell(mSharedPreferences.getString(Constants.electrical_lttrans[0],""));
        table2.addCell(mSharedPreferences.getString(Constants.electrical_lttrans[1],""));
        table2.addCell(mSharedPreferences.getString(Constants.electrical_lttrans[2],""));
        table2.addCell("UST-B");
        table2.addCell(mSharedPreferences.getString(Constants.electrical_lttrans[3],""));
        table2.addCell(mSharedPreferences.getString(Constants.electrical_lttrans[4],""));
        table2.addCell(mSharedPreferences.getString(Constants.electrical_lttrans[5],""));
        table2.addCell("SST-A");
        table2.addCell(mSharedPreferences.getString(Constants.electrical_lttrans[6],""));
        table2.addCell(mSharedPreferences.getString(Constants.electrical_lttrans[7],""));
        table2.addCell(mSharedPreferences.getString(Constants.electrical_lttrans[8],""));
        table2.addCell("SST-B");
        table2.addCell(mSharedPreferences.getString(Constants.electrical_lttrans[9],""));
        table2.addCell(mSharedPreferences.getString(Constants.electrical_lttrans[10],""));
        table2.addCell(mSharedPreferences.getString(Constants.electrical_lttrans[11],""));
        Paragraph paragraph4=new Paragraph();
        addEmptyLine(paragraph4,2);
        document.add(table2);
        document.add(paragraph4);

        Paragraph paragraph5=new Paragraph();
        paragraph5.add(new Paragraph("220V DCDB",titleFont));
        addEmptyLine(paragraph5,1);
        document.add(paragraph5);
        PdfPTable table3=new PdfPTable(4);
        PdfPCell c5 = new PdfPCell(new Phrase("",catFont1));
        c5.setHorizontalAlignment(Element.ALIGN_CENTER);
        table3.addCell(c5);
        c5 = new PdfPCell(new Phrase("P-E",catFont1));
        c5.setHorizontalAlignment(Element.ALIGN_CENTER);
        table3.addCell(c5);
        c5 = new PdfPCell(new Phrase("N-E",catFont1));
        c5.setHorizontalAlignment(Element.ALIGN_CENTER);
        table3.addCell(c5);
        c5 = new PdfPCell(new Phrase("P-N",catFont1));
        c5.setHorizontalAlignment(Element.ALIGN_CENTER);
        table3.addCell(c5);
        table3.setHeaderRows(1);
        table3.addCell("Section A");
        table3.addCell(mSharedPreferences.getString(Constants.electrical_dcdb[0],""));
        table3.addCell(mSharedPreferences.getString(Constants.electrical_dcdb[1],""));
        table3.addCell(mSharedPreferences.getString(Constants.electrical_dcdb[2],""));
        table3.addCell("Section B");
        table3.addCell(mSharedPreferences.getString(Constants.electrical_dcdb[0],""));
        table3.addCell(mSharedPreferences.getString(Constants.electrical_dcdb[1],""));
        table3.addCell(mSharedPreferences.getString(Constants.electrical_dcdb[2],""));
        table3.addCell("Bus Coupler Status");
        PdfPCell cx = new PdfPCell(new Phrase(mSharedPreferences.getString(Constants.electrical_dcdb[0],"")));
        cx.setHorizontalAlignment(Element.ALIGN_CENTER);
        cx.setColspan(3);
        table3.addCell(cx);
        Paragraph paragraph6=new Paragraph();
        addEmptyLine(paragraph6,2);
        document.add(table3);
        document.add(paragraph6);

        Paragraph paragraph7=new Paragraph();
        paragraph7.add(new Paragraph("HT SWGR",titleFont));
        addEmptyLine(paragraph7,1);
        document.add(paragraph7);
        PdfPTable table4=new PdfPTable(4);
        PdfPCell c6 = new PdfPCell(new Phrase("",catFont1));
        c6.setHorizontalAlignment(Element.ALIGN_CENTER);
        table4.addCell(c6);
        c6 = new PdfPCell(new Phrase("VOLT",catFont1));
        c6.setHorizontalAlignment(Element.ALIGN_CENTER);
        table4.addCell(c6);
        c6 = new PdfPCell(new Phrase("Current",catFont1));
        c6.setHorizontalAlignment(Element.ALIGN_CENTER);
        table4.addCell(c6);
        c6 = new PdfPCell(new Phrase("B/C Status",catFont1));
        c6.setHorizontalAlignment(Element.ALIGN_CENTER);
        table4.addCell(c6);
        table4.setHeaderRows(1);
        table4.addCell("UA");
        table4.addCell(mSharedPreferences.getString(Constants.electrical_htswgr[0],""));
        table4.addCell(mSharedPreferences.getString(Constants.electrical_htswgr[1],""));
        table4.addCell(mSharedPreferences.getString(Constants.electrical_htswgr[2],""));
        table4.addCell("UB");
        table4.addCell(mSharedPreferences.getString(Constants.electrical_htswgr[3],""));
        table4.addCell(mSharedPreferences.getString(Constants.electrical_htswgr[4],""));
        table4.addCell(mSharedPreferences.getString(Constants.electrical_htswgr[5],""));
        table4.addCell("SA");
        table4.addCell(mSharedPreferences.getString(Constants.electrical_htswgr[6],""));
        table4.addCell(mSharedPreferences.getString(Constants.electrical_htswgr[7],""));
        table4.addCell(mSharedPreferences.getString(Constants.electrical_htswgr[8],""));
        table4.addCell("SB");
        table4.addCell(mSharedPreferences.getString(Constants.electrical_htswgr[9],""));
        table4.addCell(mSharedPreferences.getString(Constants.electrical_htswgr[10],""));
        table4.addCell(mSharedPreferences.getString(Constants.electrical_htswgr[11],""));
        table4.addCell("UAA-A");
        table4.addCell(mSharedPreferences.getString(Constants.electrical_htswgr[12],""));
        table4.addCell(mSharedPreferences.getString(Constants.electrical_htswgr[13],""));
        table4.addCell(mSharedPreferences.getString(Constants.electrical_htswgr[14],""));
        table4.addCell("UAA-B");
        table4.addCell(mSharedPreferences.getString(Constants.electrical_htswgr[15],""));
        table4.addCell(mSharedPreferences.getString(Constants.electrical_htswgr[16],""));
        table4.addCell(mSharedPreferences.getString(Constants.electrical_htswgr[17],""));
        Paragraph paragraph8=new Paragraph();
        addEmptyLine(paragraph8,2);
        document.add(table4);
        document.add(paragraph8);

        Paragraph paragraph9=new Paragraph();
        paragraph9.add(new Paragraph("LT SWGR",titleFont));
        addEmptyLine(paragraph9,1);
        document.add(paragraph9);
        PdfPTable table5=new PdfPTable(4);
        PdfPCell c7 = new PdfPCell(new Phrase("",catFont1));
        c7.setHorizontalAlignment(Element.ALIGN_CENTER);
        table5.addCell(c7);
        c7 = new PdfPCell(new Phrase("VOLT",catFont1));
        c7.setHorizontalAlignment(Element.ALIGN_CENTER);
        table5.addCell(c7);
        c7 = new PdfPCell(new Phrase("CURRENT",catFont1));
        c7.setHorizontalAlignment(Element.ALIGN_CENTER);
        table5.addCell(c7);
        c7 = new PdfPCell(new Phrase("B/C STATUS",catFont1));
        c7.setHorizontalAlignment(Element.ALIGN_CENTER);
        table5.addCell(c7);
        table5.setHeaderRows(1);

        table5.addCell("USS-A");
        table5.addCell(mSharedPreferences.getString(Constants.electrical_ltswgr[0],""));
        table5.addCell(mSharedPreferences.getString(Constants.electrical_ltswgr[1],""));
        table5.addCell(mSharedPreferences.getString(Constants.electrical_ltswgr[2],""));
        table5.addCell("USS-B");
        table5.addCell(mSharedPreferences.getString(Constants.electrical_ltswgr[3],""));
        table5.addCell(mSharedPreferences.getString(Constants.electrical_ltswgr[4],""));
        table5.addCell(mSharedPreferences.getString(Constants.electrical_ltswgr[5],""));
        table5.addCell("SSS-A");
        table5.addCell(mSharedPreferences.getString(Constants.electrical_ltswgr[6],""));
        table5.addCell(mSharedPreferences.getString(Constants.electrical_ltswgr[7],""));
        table5.addCell(mSharedPreferences.getString(Constants.electrical_ltswgr[8],""));
        table5.addCell("SSS-B");
        table5.addCell(mSharedPreferences.getString(Constants.electrical_ltswgr[9],""));
        table5.addCell(mSharedPreferences.getString(Constants.electrical_ltswgr[10],""));
        table5.addCell(mSharedPreferences.getString(Constants.electrical_ltswgr[11],""));
        table5.addCell("SACDB-A");
        table5.addCell(mSharedPreferences.getString(Constants.electrical_ltswgr[12],""));
        table5.addCell(mSharedPreferences.getString(Constants.electrical_ltswgr[13],""));
        table5.addCell(mSharedPreferences.getString(Constants.electrical_ltswgr[14],""));
        table5.addCell("SACDB-B");
        table5.addCell(mSharedPreferences.getString(Constants.electrical_ltswgr[15],""));
        table5.addCell(mSharedPreferences.getString(Constants.electrical_ltswgr[16],""));
        table5.addCell(mSharedPreferences.getString(Constants.electrical_ltswgr[17],""));
        table5.addCell("TMCC-A");
        table5.addCell(mSharedPreferences.getString(Constants.electrical_ltswgr[18],""));
        table5.addCell(mSharedPreferences.getString(Constants.electrical_ltswgr[19],""));
        table5.addCell(mSharedPreferences.getString(Constants.electrical_ltswgr[20],""));
        table5.addCell("TMCC-B");
        table5.addCell(mSharedPreferences.getString(Constants.electrical_ltswgr[21],""));
        table5.addCell(mSharedPreferences.getString(Constants.electrical_ltswgr[22],""));
        table5.addCell(mSharedPreferences.getString(Constants.electrical_ltswgr[23],""));
        table5.addCell("BMCC-A");
        table5.addCell(mSharedPreferences.getString(Constants.electrical_ltswgr[24],""));
        table5.addCell(mSharedPreferences.getString(Constants.electrical_ltswgr[25],""));
        table5.addCell(mSharedPreferences.getString(Constants.electrical_ltswgr[26],""));
        table5.addCell("BMCC-B");
        table5.addCell(mSharedPreferences.getString(Constants.electrical_ltswgr[27],""));
        table5.addCell(mSharedPreferences.getString(Constants.electrical_ltswgr[28],""));
        table5.addCell(mSharedPreferences.getString(Constants.electrical_ltswgr[29],""));
        table5.addCell("BVDACDB");
        table5.addCell(mSharedPreferences.getString(Constants.electrical_ltswgr[45],""));
        table5.addCell(mSharedPreferences.getString(Constants.electrical_ltswgr[46],""));
        table5.addCell(mSharedPreferences.getString(Constants.electrical_ltswgr[47],""));
        table5.addCell("TVACDB");
        table5.addCell(mSharedPreferences.getString(Constants.electrical_ltswgr[30],""));
        table5.addCell(mSharedPreferences.getString(Constants.electrical_ltswgr[31],""));
        table5.addCell(mSharedPreferences.getString(Constants.electrical_ltswgr[32],""));
        table5.addCell("BACDB-A");
        table5.addCell(mSharedPreferences.getString(Constants.electrical_ltswgr[33],""));
        table5.addCell(mSharedPreferences.getString(Constants.electrical_ltswgr[34],""));
        table5.addCell(mSharedPreferences.getString(Constants.electrical_ltswgr[35],""));
        table5.addCell("BACDB-B");
        table5.addCell(mSharedPreferences.getString(Constants.electrical_ltswgr[36],""));
        table5.addCell(mSharedPreferences.getString(Constants.electrical_ltswgr[37],""));
        table5.addCell(mSharedPreferences.getString(Constants.electrical_ltswgr[38],""));
        table5.addCell("BOT MCC-A");
        table5.addCell(mSharedPreferences.getString(Constants.electrical_ltswgr[48],""));
        table5.addCell(mSharedPreferences.getString(Constants.electrical_ltswgr[49],""));
        table5.addCell(mSharedPreferences.getString(Constants.electrical_ltswgr[50],""));
        table5.addCell("BOT MCC-B");
        table5.addCell(mSharedPreferences.getString(Constants.electrical_ltswgr[51],""));
        table5.addCell(mSharedPreferences.getString(Constants.electrical_ltswgr[52],""));
        table5.addCell(mSharedPreferences.getString(Constants.electrical_ltswgr[53],""));
        table5.addCell("SB MCC");
        table5.addCell(mSharedPreferences.getString(Constants.electrical_ltswgr[54],""));
        table5.addCell(mSharedPreferences.getString(Constants.electrical_ltswgr[55],""));
        table5.addCell(mSharedPreferences.getString(Constants.electrical_ltswgr[56],""));
        table5.addCell("AW/AHU MCC-A");
        table5.addCell(mSharedPreferences.getString(Constants.electrical_ltswgr[39],""));
        table5.addCell(mSharedPreferences.getString(Constants.electrical_ltswgr[40],""));
        table5.addCell(mSharedPreferences.getString(Constants.electrical_ltswgr[41],""));
        table5.addCell("AW/AHU MCC-B");
        table5.addCell(mSharedPreferences.getString(Constants.electrical_ltswgr[42],""));
        table5.addCell(mSharedPreferences.getString(Constants.electrical_ltswgr[43],""));
        table5.addCell(mSharedPreferences.getString(Constants.electrical_ltswgr[44],""));
        Paragraph paragraph10=new Paragraph();
        addEmptyLine(paragraph10,2);
        document.add(table5);
        document.add(paragraph10);

        Paragraph paragraph11=new Paragraph();
        paragraph11.add(new Paragraph("220 V DC CHARGER",titleFont));
        addEmptyLine(paragraph11,1);
        document.add(paragraph11);
        PdfPTable table6=new PdfPTable(4);
        PdfPCell c8 = new PdfPCell(new Phrase("",catFont1));
        c8.setHorizontalAlignment(Element.ALIGN_CENTER);
        table6.addCell(c8);
        c8 = new PdfPCell(new Phrase("AC VOLT",catFont1));
        c8.setHorizontalAlignment(Element.ALIGN_CENTER);
        table6.addCell(c8);
        c8 = new PdfPCell(new Phrase("DC VOLT",catFont1));
        c8.setHorizontalAlignment(Element.ALIGN_CENTER);
        table6.addCell(c8);
        c8 = new PdfPCell(new Phrase("DC(A)",catFont1));
        c8.setHorizontalAlignment(Element.ALIGN_CENTER);
        table6.addCell(c8);
        table6.setHeaderRows(1);
        table6.addCell("CH-1");
        table6.addCell(mSharedPreferences.getString(Constants.electrical_dccharger[0],""));
        table6.addCell(mSharedPreferences.getString(Constants.electrical_dccharger[1],""));
        table6.addCell(mSharedPreferences.getString(Constants.electrical_dccharger[2],""));
        table6.addCell("CH-2");
        table6.addCell(mSharedPreferences.getString(Constants.electrical_dccharger[3],""));
        table6.addCell(mSharedPreferences.getString(Constants.electrical_dccharger[4],""));
        table6.addCell(mSharedPreferences.getString(Constants.electrical_dccharger[5],""));
        Paragraph paragraph12=new Paragraph();
        addEmptyLine(paragraph12,2);
        document.add(table6);
        document.add(paragraph12);

        Paragraph paragraph14=new Paragraph();
        paragraph14.add(new Paragraph("Remarks",titleFont));
        addEmptyLine(paragraph14,1);
        paragraph14.add(new Paragraph(mSharedPreferences.getString(Constants.remarkselectrical,"")));
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
