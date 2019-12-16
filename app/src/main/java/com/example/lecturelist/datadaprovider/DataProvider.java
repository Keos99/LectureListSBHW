package com.example.lecturelist.datadaprovider;

import android.content.Context;

import com.example.lecturelist.R;
import com.example.lecturelist.model.LectureItem;
import com.example.lecturelist.model.RowType;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import static com.example.lecturelist.properties.Properties.*;

public class DataProvider {

    public final int POSITION_ALL = 0;

    private List<RowType> mLectures;
    private SimpleDateFormat mFormat;
    private Context mContext;

    public DataProvider(Context context) {
        mContext = context;
        mFormat = new SimpleDateFormat(LECTURE_ADAPTER_DATE_FORMATE,Locale.getDefault());
        mLectures = new ArrayList<>();
        initLectures();
    }

    private void initLectures(){
        mLectures.add(new LectureItem(1, "12.11.2019", "Вводное занятие", "Соколов"));
        mLectures.add(new LectureItem(2, "14.11.2019", "View, Layouts", "Соколов"));
        mLectures.add(new LectureItem(3, "16.11.2019", "Drawables", "Соколов"));
        mLectures.add(new LectureItem(4, "19.11.2019", "Activity", "Сафарян"));
        mLectures.add(new LectureItem(5, "21.11.2019", "Адаптеры", "Чумак"));
        mLectures.add(new LectureItem(5, "21.11.2019", "Адаптеры", "Чумак"));
        mLectures.add(new LectureItem(6, "23.11.2019", "UI: практика", "Кудрявцев"));
        mLectures.add(new LectureItem(7, "26.11.2019", "Custom View", "Кудрявцев"));
        mLectures.add(new LectureItem(8, "28.11.2019", "Touch events", "Бильчук"));
        mLectures.add(new LectureItem(9, "30.11.2019", "Сложные жесты", "Соколов"));
        mLectures.add(new LectureItem(10, "03.12.2019", "Layout & Measurement", "Кудрявцев"));
        mLectures.add(new LectureItem(11, "05.12.2019", "Custom ViewGroup", "Кудрявцев"));
        mLectures.add(new LectureItem(12, "07.12.2019", "Анимации", "Чумак"));
        mLectures.add(new LectureItem(13, "10.12.2019", "Практика View", "Соколов"));
        mLectures.add(new LectureItem(14, "12.12.2019", "Фрагменты: база", "Бильчук"));
        mLectures.add(new LectureItem(15, "14.12.2019", "Фрагменты: практика", "Соколов"));
        mLectures.add(new LectureItem(16, "17.12.2019", "Фоновая работа", "Чумак"));
        mLectures.add(new LectureItem(17, "19.12.2019", "Абстракции фон/UI", "Леонидов"));
        mLectures.add(new LectureItem(18, "21.12.2019", "Фон: практика", "Чумак"));
        mLectures.add(new LectureItem(19, "14.01.2020", "BroadcastReceiver", "Бильчук"));
        mLectures.add(new LectureItem(20, "16.01.2020", "Runtime permissions", "Кудрявцев"));
        mLectures.add(new LectureItem(21, "18.01.2020", "Service", "Леонидов"));
        mLectures.add(new LectureItem(22, "21.01.2020", "Service: практика", "Леонидов"));
        mLectures.add(new LectureItem(23, "23.01.2020", "Service: биндинг", "Леонидов"));
        mLectures.add(new LectureItem(24, "25.01.2020", "Preferences", "Сафарян"));
        mLectures.add(new LectureItem(25, "28.01.2020", "SQLite", "Бильчук"));
        mLectures.add(new LectureItem(26, "30.01.2020", "SQLite: Room", "Соколов"));
        mLectures.add(new LectureItem(27, "01.02.2020", "ContentProvider", "Сафарян"));
        mLectures.add(new LectureItem(28, "04.02.2020", "FileProvider", "Соколов"));
        mLectures.add(new LectureItem(29, "06.02.2020", "Геолокация", "Леонидов"));
        mLectures.add(new LectureItem(30, "08.02.2020", "Material", "Чумак"));
        mLectures.add(new LectureItem(31, "11.02.2020", "UI-тесты", "Сафарян"));
        mLectures.add(new LectureItem(32, "13.02.2020", "Финал", "Соколов"));
    }

    public List<RowType> getLectures() {
        return new ArrayList<>(mLectures);
    }

    public List<String> providerLectors() {
        Set<String> templectors = new HashSet<>();

        for (int i = 0; i < mLectures.size(); i++) {
            LectureItem item = (LectureItem) mLectures.get(i);
            templectors.add(item.getLector());
        }

        ArrayList<String> lectors = new ArrayList<>(templectors);

        Collections.sort(lectors);
        lectors.add(POSITION_ALL,mContext.getString(R.string.all));
        return lectors;
    }

    public RowType getCloseLection(Date date){
        for (int i = 0; i < mLectures.size(); i++) {
            LectureItem item = (LectureItem) mLectures.get(i);
            try {
                Date tempdate = mFormat.parse(item.getDate());
                if (tempdate != null && tempdate.after(date)){
                    return item;
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public List<RowType> filterBy(String name) {
        List<RowType> result = new ArrayList<>();
        for (int i = 0; i < mLectures.size(); i++) {
            LectureItem item = (LectureItem) mLectures.get(i);
            if (item.getLector().equals(name)) {
                result.add(item);
            }
        }
        return result;
    }
}
