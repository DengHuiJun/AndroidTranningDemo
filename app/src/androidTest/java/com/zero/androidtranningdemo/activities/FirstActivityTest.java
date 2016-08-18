package com.zero.androidtranningdemo.activities;

import android.app.Instrumentation;
import android.test.ActivityInstrumentationTestCase2;
import android.test.ViewAsserts;
import android.test.suitebuilder.annotation.MediumTest;
import android.test.suitebuilder.annotation.SmallTest;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.zero.androidtranningdemo.R;

/**
 * Created by zero on 15-9-21.
 */
public class FirstActivityTest extends ActivityInstrumentationTestCase2<FirstActivity> {

    // 构造函数是由测试用的Runner调用，用于初始化测试类的。
    public FirstActivityTest() {
        super(FirstActivity.class);
    }

    private Instrumentation mInstrumentation; // 我们可以将它理解为一种没有图形界面的，具有启动能力的，用于监控其他类(用Target Package声明)的工具类
    private FirstActivity mActivity;
    private TextView mTv;
    private EditText mEt;
    private Button mBtn;

    /**
     * setUp()方法是由测试Runner在其他测试方法开始前运行的。（必要）
     * 1.调用父类构造函数，这是JUnit要求的。
     * 2.初始化测试数据集的状态，具体而言：
     * a.定义保存测试数据及状态的实例变量
     * b.创建并保存正在测试的Activity的引用实例。
     * c.获得想要测试的Activity中任何UI组件的引用。
     *
     * @throws Exception
     */
    @Override
    protected void setUp() throws Exception {
        super.setUp();

        // 把touch mode设置为真可以防止在执行编写的测试方法时，人为的UI操作获取到控件的焦点
        // 确保在调用getActivity()方法前调用了setActivityInitialTouchMode
        // setActivityInitialTouchMode(true);

        mInstrumentation = getInstrumentation();
        mActivity = getActivity();
        mTv = (TextView) mActivity.findViewById(R.id.first_tv);
        mEt = (EditText) mActivity.findViewById(R.id.first_et);
        mBtn = (Button) mActivity.findViewById(R.id.first_btn);
    }

    /**
     * 测试前提,检查测试数据集的设置是否正确，以及我们想要测试的对象是否已经正确地初始化。
     */
    public void testPreconditions() {
        assertNotNull("mActivity is null", mActivity);
        assertNotNull("mTv is null", mTv);
        assertNotNull("mEt is null", mEt);
        assertNotNull("mBtn is null", mBtn);
    }

    /**
     * 编写的测试方法
     */
    // @UiThreadTest 可用于子线程处理
    @MediumTest
    public void testClickBtn() {
        final String str = "Hello";

        // 同步处理
        mInstrumentation.runOnMainSync(new Runnable() {
            @Override
            public void run() {
                mEt.setText(str); // 设置测试数据
                mBtn.requestFocus(); // 得到焦点
                mBtn.performClick(); // 模拟点击事件
                assertEquals(str, mTv.getText().toString()); // 判断结果
            }
        });

//        如果不是Btn，其它View的点击可使用TouchUtils
//        TouchUtils.clickView(this, mBtn);
    }

    /**
     * 注意:TouchUtils辅助类提供与应用程序交互的方法可以方便进行模拟触摸操作。
     * 我们可以使用这些方法来模拟点击，轻敲，或应用程序屏幕拖动View。
     * <p/>
     * 警告:TouchUtils方法的目的是将事件安全地从测试线程发送到UI线程。
     * 我们不可以直接在UI线程或任何标注@UIThread的测试方法中使用TouchUtils这样做可能会增加错误线程异常。
     */

    @SmallTest
    public void testBtnLayout() {
        final View decorView = mActivity.getWindow().getDecorView(); // 获取最上层的ViewGroup(FrameLayout)的引用
        ViewAsserts.assertOnScreen(decorView, mBtn); // 检测一个view是否包含在Activity的根视图View中
    }

    /**
     * @SmallTest 标志该测试方法是小型测试的一部分。
     * @MediumTest 标志该测试方法是中等测试的一部分。
     * @LargeTest 标志该测试方法是大型测试的一部分。
     * 通常情况下，如果测试方法只需要几毫秒的时间，那么它应该被标记为@SmallTest，
     * 长时间运行的测试（100毫秒或更多）通常被标记为@MediumTest或@LargeTest，
     * 这主要取决于测试访问资源在网络上或在本地系统
     */

    /**
     * 垃圾清理与资源回收（非必要）
     * @throws Exception
     */
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }
}
