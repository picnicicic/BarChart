package com.example.barchart

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.components.AxisBase
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.formatter.ValueFormatter
import com.github.mikephil.charting.utils.ColorTemplate

class MainActivity : AppCompatActivity() {

    private lateinit var barChart: BarChart

   override fun onCreate(savedInstanceStated:Bundle?) {
        super.onCreate(savedInstanceStated)
        setContentView(R.layout.activity_main)

       barChart = findViewById(R.id.bar_chart)

        val entries = listOf(
            BarEntry(1f,10f),
            BarEntry(2f,20f),
            BarEntry(3f,30f),
            BarEntry(4f,40f),
            BarEntry(5f,50f),
        )

        val dataSet = BarDataSet(entries, "My Bar Chart")
        dataSet.setColors(ColorTemplate.COLORFUL_COLORS,255)

        val barData = BarData(dataSet)
        barChart.data = barData

        barChart.setDrawValueAboveBar(true)
        barChart.description.isEnabled = false
        barChart.setPinchZoom(false)
        barChart.setDrawGridBackground(false)

        val xAxis = barChart.xAxis
        xAxis.granularity = 1f
        xAxis.setCenterAxisLabels(true)
        xAxis.valueFormatter = object  : ValueFormatter() {
            override fun getAxisLabel(value: Float, axis: AxisBase?): String {
                return "Label " + value.toInt()
            }
        }

        val yAxisLeft = barChart.axisLeft
        yAxisLeft.setDrawGridLines(false)
        yAxisLeft.axisMinimum = 0f

        val yAxisRight = barChart.axisRight
        yAxisRight.setDrawGridLines(false)
        yAxisRight.axisMinimum = 0f

    }
}