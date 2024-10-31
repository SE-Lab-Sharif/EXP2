# EXP2
### گام ۱: افزودن یک روش پیام رسانی دیگر

	تغییراتی را که در کد فعلی برنامه می‌دهید، در جدول زیر ثبت کنید و در نهایت تعداد کل تغییرات را اعلان کنید.
    - توجه: مواردی که به عنوان تغییرات باید اعلان شود شامل این موارد هستند:
      1. ساخت کلاس جدید
      2. افزودن تابع جدید به کلاس و یا واسط (برای توابع جدید صرفا اعلام تغییر کنید)
      3. هر خطوط پیاپی‌ای که در تابع main و برای افزودن یک قابلیت جدید اضافه می‌کنید. به عنوان مثال اگر سه خط را به منظور تشخیص نوع پیام اضافه می‌کنید، آن سه خط را در قالب یک تغییر اعلام کنید (البته جزییات آن را در ستون «شرحی کوتاه از تغییر» توضیح دهید).

<table dir='rtl'>
<tbody>
<tr>
<td width="64">
<p><strong>ردیف</strong></p>
</td>
<td width="198">
<p><strong>محل اعمال تغییرات (کلاس/واسط)</strong></p>
</td>
<td width="141">
<p><strong>عنوان تغییر</strong></p>
</td>
<td width="292">
<p><strong>شرحی کوتاه از تغییر</strong></p>
</td>
</tr>
<tr>
<td width="64">
<p><strong>۱</strong></p>
</td>
<td width="198">
<p>MessageService</p>
</td>
<td width="141">
<p>افزودن اینترفیس ارسال پیام</p>
</td>
<td width="292">
<p>افزودن یک تابع void با عنوان sendMessage</p>
</td>
</tr>

<tr>
<td width="64">
<p><strong>۲</strong></p>
</td>
<td width="198">
<p>TelegramService</p>
</td>
<td width="141">
<p>ارث بری از MessageService</p>
</td>
<td width="292">
<p> پیاده سازی تابع ارسال پیام برای سرویس تلگرام</p>
</td>
</tr>
<tr>
<td width="64">
<p><strong>۳</strong></p>
</td>
<td width="198">
<p>OnlineOrderService</p>
</td>
<td width="141">
<p>اضافه کردن امکان پیام رسانی به اردر های آنلاین</p>
</td>
<td width="292">
<p>اضافه کردن فیلد مسیجینگ به این کلاس</p>
</td>
</tr>
<tr>
<td width="64">
<p><strong>۴</strong></p>
</td>
<td width="198">
<p>OnSiteOrderService</p>
</td>
<td width="141">
<p>اضافه کردن امکان پیام رسانی به اردر های حضوری</p>
</td>
<td width="292">
<p>اضافه کردن فیلد مسیجینگ به این کلاس</p>
</td>
</tr>
<tr>
<td width="64">
<p><strong>۵</strong></p>
</td>
<td width="198">
<p>Main</p>
</td>
<td width="141">
<p>
اضافه کردن امکان پیام رسانی
</p>
</td>
<td width="292">
<p>
اضافه کردن فیلد تلگرام مسیجینگ به بدنه تابع مین
</p>
</td>
</tr>

</tbody>
</table>

مجموع تعداد تغییرات: 5

### گام ۲: تحلیل و وارسی برنامه از منظر تحقق و یا عدم تحقق اصول SOLID
<table dir='rtl'>
<tbody>
<tr>
<td rowspan="2" width="240">
<p>اصل 1</p>
<p>Single Responsibility</p>
</td>
<td width="95">
<p><strong>موارد تحقق</strong></p>
</td>
<td width="454">
<p>
کلاس‌های OnlineOrderService و OnSiteOrderService تنها وظیفه پردازش و ثبت سفارشات و همچنین پرداخت‌ها را بر عهده دارند. اما این کلاس‌ها از MessagingService نیز استفاده می‌کنند تا پیام‌ها را ارسال کنند.
</p>
</td>
</tr>
<tr>
<td>
<p><strong>موارد نقض</strong></p>
</td>
<td>
<p>
با اضافه شدن ارسال پیام به این کلاس‌ها، اصل تک‌مسئولیتی نقض می‌شود، زیرا اکنون علاوه بر مدیریت سفارش، وظیفه ارسال پیام را نیز بر عهده دارند.
</p>
</td>
</tr>
<tr>
<td rowspan="2">
<p>اصل 2</p>
<p>Open-Close Principle (OCP)</p>
</td>
<td>
<p><strong>موارد تحقق</strong></p>
</td>
<td>
<p>
با استفاده از اینترفیس MessagingService، می‌توانیم پیام‌رسان‌های دیگری مانند سرویس ایمیل را بدون نیاز به تغییر در کد موجود اضافه کنیم.
</p>
</td>
</tr>
<tr>
<td>
<p><strong>موارد نقض</strong></p>
</td>
<td>
<p>
برای OrderService به دلیل نیاز به تغییر کد Main در صورت اضافه شدن پیام‌رسان‌های دیگر، هنوز OCP کامل نیست.
</p>
</td>
</tr>
<tr>
<td rowspan="2">
<p>اصل 3</p>
<p>Liskov Substitution Principle</p>
</td>
<td>
<p><strong>موارد تحقق</strong></p>
</td>
<td>
<p>
کلاس TelegramService به درستی این اصل را رعایت می‌کند، زیرا می‌تواند به عنوان پیاده‌سازی MessagingService در همه جا به کار رود.
</p>
</td>
</tr>
<tr>
<td>
<p><strong>موارد نقض</strong></p>
</td>
<td>
<p>&nbsp;</p>
</td>
</tr>
<tr>
<td rowspan="2">
<p>اصل 4</p>
<p>Interface Segregation Principle</p>
</td>
<td>
<p><strong>موارد تحقق</strong></p>
</td>
<td>
<p>
MessagingService تنها یک متد sendMessage دارد و از اصل ISP تبعیت می‌کند.</p>
</td>
</tr>
<tr>
<td>
<p><strong>موارد نقض</strong></p>
</td>
<td>
<p>&nbsp;</p>
</td>
</tr>
<tr>
<td rowspan="2">
<p>اصل 5</p>
<p>Dependency Inversion Principle</p>
</td>
<td>
<p><strong>موارد تحقق</strong></p>
</td>
<td>
<p>
در این کد، کلاس‌های OrderService به جای وابستگی به TelegramService مستقیماً از MessagingService استفاده می‌کنند که به درستی DIP را رعایت کرده‌اند.
</p>
</td>
</tr>
<tr>
<td>
<p><strong>موارد نقض</strong></p>
</td>
<td>
<p>وابستگی به MessagingService به صورت دستی در Main ساخته شده و این می‌تواند در پروژه‌های بزرگ مشکل‌ساز شود.</p>
</td>
</tr>
</tbody>
</table>

در خصوص هرکدام از موارد نقض هرکدام از اصول، یک راهکار را به منظور رفع آن مشکل ارایه داده و در جدول زیر ثبت نمایید:

<table dir='rtl'>
<tbody>
<tr>
<td width="168">
<p><strong>اصل مربوطه (از اصول </strong><strong>SOLID</strong><strong>)</strong></p>
</td>
<td width="246">
<p><strong>علت نقض</strong></p>
</td>
<td width="284">
<p><strong>راه حل پیشنهادی</strong></p>
</td>
</tr>
<tr>
<td width="168">
<p>Single Responsibility</p>
</td>
<td width="246">
<p>اکنون علاوه بر مدیریت سفارش، وظیفه ارسال پیام را نیز بر عهده دارند.</p>
</td>
<td width="284">
<p>اضافه کردن کلاس OrderNotifier: این کلاس مسئول ارسال پیام‌ها می‌شود و از MessagingService استفاده می‌کند.</p>
</td>
</tr>
<tr>
<td width="168">
<p>OCP</p>
</td>
<td width="246">
<p>برای OrderService به دلیل نیاز به تغییر کد Main در صورت اضافه شدن پیام‌رسان‌های دیگر، هنوز OCP کامل نیست.</p>
</td>
<td width="284">
<p>ایجاد OrderServiceFactory: این کلاس به ایجاد نمونه‌های OrderService و وابستگی‌های لازم آن‌ها کمک می‌کند و اصل وارونگی وابستگی و باز برای توسعه و بسته برای تغییر را تقویت می‌کند.</p>
</td>
</tr>
<tr>
<td width="168">
<p>DIP</p>
</td>
<td width="246">
<p>وابستگی به MessagingService به صورت دستی در Main ساخته شده و این می‌تواند در پروژه‌های بزرگ مشکل‌ساز شود.</p>
</td>
<td width="284">
<p>استفاده از Dependency Injection که می‌تواند به بهبود مدیریت وابستگی ها منجر بشود.</p>
</td>
</tr>

</tbody>
</table>

### گام ۳: اصلاح موارد نقض
در نهایت، بر اساس تحلیلی که انجام داده‌اید و راه حل‌هایی که در بخش قبل ارایه کردید، کد را اصلاح کرده و بر روی مخزن گیت‌هاب و در پوشه‌ای مجزا از گام قبل commit و push کنید. انتظار می‌رود که تمامی راه حل‌های پیشنهادی خود را بر روی این نسخه اعمال کنید و تمامی بهبودهایی که انجام می‌دهید، در جداول بخش قبل موجود باشد.

### گام ۴: بررسی مجدد تغییرات مورد نیاز
فرض کنید که گام 1 را برای کد اصلاح شده (پس از انجام گام‌های ۲ و ۳) اجرا کرده‌اید.

<lr>
1. در این صورت از انجام کدام یک از تغییرات ثبت شده در جدول گام ۱ معاف خواهید شد؟
</lr>

فرض کنید می‌خواهیم مثل گام۱، یک نوع جدیدی از ارسال پیام را به برنامه اضافه کنیم. مثلا می‌خواهیم علاوه بر روش کنونی که اطلاع‌رسانی از طریق تلگرام است، از طریق email هم پیام ارسال کنیم. برای این‌کار باید چه تغییراتی اعمال شود؟ آنها را بررسی می‌کنیم:

<ul>
<li> نیازی به تغییر در کلاس‌های <code>OrderService</code> نداشتیم:

فرض کنیم که اصلاحات فاز ۱ را انجام نداده بودیم. در اینصورت باید کلاس‌های <code>OrderService</code> را تغییر می‌دادیم زیرا سیستم پیام‌رسانی هم داخل این کلاس‌ها ا‌نجام می‌شد. اما حالا با انجام اصل <code>Single Responsibility</code> این سیستم توسط کلاس <code>OrderNotifier</code> انجام می‌شود. درنتیجه نیازی به تغییر کلاس‌های <code>OnlineOrderService</code> و <code>OnSireOrderService</code> نیست. (و حتی هر روش Order ی که بعدا اضافه شود و اینترفیس <code>OrderService</code> را implement کند.) فقط و فقط کافی‌ست که کلاس مربوط به email را در پکیج <code>MessagingServices</code> پیاده سازی کنیم. مثلا، کافی‌ست یک کلاس <code>EmailingService</code> بصورت زیر بسازیم.

</li>

```java
package MessagingServices;

public class EmailingService implements MessagingService {

    @Override
    public void sendMessage(String message) {
        System.out.println("Sending message via Email: " + message);
    }
}
```

اما اگر این تغییرات را نداده بودیم و مثلا می‌خواستیم که notification هم از طریق تلگرام و هم از طریق ایمیل برای شخص ارسال شود (یعنی از ۲ طریق) باید کدهای درون کلاس‌هایی که اینترفیس <code>OrderService</code> را پیاده می‌کردند، تغییر می‌دادیم. مثلا باید چنین کدی می‌نوشتیم (بصورت reduntant درکلاس‌های مختلف OrderService):

```java
package PaymentServices;
import MessagingServices.MessagingService;

public class OnlineOrderService implements OrderService {
    private MessagingService messagingServiceOne;
    private MessagingService messagingServiceTwo;

    public OnlineOrderService(MessagingService messagingServiceOne, MessagingService messagingServiceTwo) {
        this.messagingServiceOne = messagingServiceOne;

        this.messagingServiceTwo = messagingServiceTwo;
    }

    @Override
    public void onSiteOrderRegister(String customerName) {
        //Empty Body!
    }

    @Override
    public void onlineOrderRegister(String customerName) {
        System.out.println("online order registered for " + customerName);
        messagingServiceOne.sendMessage("Order registered for " + customerName);
        messagingServiceTwo.sendMessage("Order registered for " + customerName);
    }

    @Override
    public void onSiteOrderPayment(int foodPrice) {
        //Empty Body
    }

    @Override
    public void onlineOrderPayment(int foodPrice) {
        System.out.println("online Payment with Price : " + foodPrice + " Tomans!");
        messagingServiceOne.sendMessage("Payment completed for " + foodPrice + " Tomans!");
        messagingServiceTwo.sendMessage("Payment completed for " + foodPrice + " Tomans!");
    }
}
```

<li> نیازی به تغیر در <code>OrderNotifier</code> نیست:

ما <code>OrderNotifier</code> را طوری نوشته‌ایم که برای اضافه کردن یک سرویس ارتباطی جدید، نیازی به تغییر در آن نیست و با همه‌ی انواع <code>MessaginService</code> کار می‌کند. مثلا برای افزودن راه ارتباطی "ارسال پیام از طریق Whatsapp" کافی‌است که کلاس زیر را تعریف کنیم:
</li>

```java
package MessagingServices;

public class WhatsappService implements MessagingService {

    @Override
    public void sendMessage(String message) {
        System.out.println("Sending message via Whatsapp: " + message);
    }
}
```
<li> نیازی به تغییر در کد <code>Main</code> نیست:

از آنجا که از <code>OrderServiceFactory</code> در جهت ایجاد و تزریق نوع پیامرسانی استفاده می‌کنیم، دیگر نیازی به تغییر کد Main نداریم. فقط کافی است تا نوع سرویس جدید خود را بعنوان نوع پیام‌رسانی وارد کنیم.
</li>
</ul>

<lr>
2. تعداد تغییرات مورد نیاز، چند تغییر خواهد شد؟
</lr>

بیایید مجددا کیس افزودن راه ارتباطی ایمیل را درنظر بگیریم. در این کیس همانطور که در بالا توضیح داده شد، یک کلاس `EmailService` لازم داریم که اینترفیس `MessagingService` را implement کند. پیاده‌سازی نمونه‌ی این کلاس را در بالا نوشته‌ایم و می‌توانید مشاهده کنید.

در ادامه، اگر بخواهیم که در `Main` یا هرکجای دیگر برنامه از این نوع سرویس استفاده کنیم، کافی‌است که `EmailService` را به عنوان نوع `MessagingService` به `OrderServiceFactory` یا `OrderNotifier` وارد کنیم.

با این توضیحات، همین ۲ تغییر برای اضافه کردن این قابلیت کافی است.


### گام ۵: جمع بندی
در این بخش، بیان کنید که از این گام چه نتیجه‌ای گرفته‌اید؟ و به نظر شما به کارگیری صحیح اصول SOLID در گام‌های ۳ و ۴ چه مزایایی را نسبت به حالتی دارد که این اصول رعایت نشده‌بود؟

در گام قبلی، دیدیم که پیاده‌سازی و اضافه‌کردن یک فیچر جدید مثل یک روش پیام‌رسانی جدید، اگر اصول SOLID را رعایت کرده باشیم چقدر ساده می‌شود و با تغییرات کمی قابل انجام است. حتی برای انجام کارهای پیچیده‌تر، مثل همان مثالی که در بخش قبل به آن اشاره کردیم برای اطلاع‌رسانی از طریق ۲ روش ارتباطی بصورت همزمان (مثلا ایمیل و تلگرام همزمان) نیز وقتی SOLID را رعایت کرده‌ایم، بسیار ساده‌تر و با کمترین تغییرات و افزودنی قابل انجام است. درواقع، رعایت این اصول به ما امکان می‌دهد بدون تغییرات زیاد یا تداخل در بخش‌های دیگر، سیستم را توسعه دهیم.



به‌کارگیری اصول **SOLID** در گام‌های قبلی مزایای زیر را به همراه دارد:

<lr>
1. <b>کاهش نیاز به تغییر در کلاس‌های موجود</b>: به دلیل جدا بودن مسئولیت‌ها و وابستگی‌ها، افزودن قابلیت‌های جدید مستلزم تغییر در ساختار اصلی کلاس‌ها نیست. این باعث می‌شود کلاس‌های موجود پایدارتر و قابل اعتمادتر باشند.
</lr>

<br/>
<lr>
2. <b>توسعه‌پذیری و انعطاف بالا</b>: با رعایت اصولی مانند <b>Open-Closed Principle</b> و <b>Dependency Inversion Principle</b>، سیستم به راحتی قابل توسعه و افزودن سرویس‌های جدید (مانند <code>EmailService</code> و یا <code>WhatsappService</code>) است. این امر بدون تغییر در کلاس‌های دیگر و با تزریق وابستگی‌ها امکان‌پذیر است.
</lr>

<br/>
<lr>
3. <b>مدیریت بهتر و ساده‌تر وابستگی‌ها</b>: از آنجا که در طراحی از اصول <b>Dependency Inversion</b> و <b>Single Responsibility</b> پیروی شده است، وابستگی‌ها به شکل موثری مدیریت می‌شوند و اضافه کردن وابستگی‌های جدید باعث پیچیدگی کد نمی‌شود.
</lr>

<br/>
<lr>
4. <b>کاهش احتمال بروز خطا و افزایش قابلیت تست‌پذیری</b>: به دلیل جدا بودن مسئولیت‌ها و استقلال کلاس‌ها، تست‌پذیری بالاتری فراهم می‌شود و می‌توان بخش‌های مختلف را به صورت جداگانه تست کرد، که این به کاهش احتمال بروز خطا کمک می‌کند.
</lr>

بنابراین، رعایت اصول **SOLID**، در مقایسه با حالتی که این اصول رعایت نمی‌شد، موجب می‌شود که سیستم پایدارتر، قابل توسعه‌تر، و انعطاف‌پذیرتر باشد و در عین حال، هزینه‌های نگهداری و توسعه را نیز کاهش می‌دهد.
