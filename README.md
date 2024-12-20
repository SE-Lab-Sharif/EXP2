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
<p>افزودن یک تابع void با عنوان sendTelegramMessage</p>
</td>
</tr>

<tr>
<td width="64">
<p><strong>۲</strong></p>
</td>
<td width="198">
<p>TelegramMessageService</p>
</td>
<td width="141">
<p>پیاده سازی تابع ارسال پیام برای سرویس تلگرام</p>
</td>
<td width="292">
<p> پیاده سازی تابع sendTelegramMessage برای ارسال پیام تلگرام</p>
</td>
</tr>
<tr>
<td width="64">
<p><strong>۳</strong></p>
</td>
<td width="198">
<p>Main</p>
</td>
<td width="141">
<p>اضافه کردن گزینه ارسال پیام تلگرامp>
</td>
<td width="292">
<p>اضافه کردن گزینه‌ای برای ارسال پیام تلگرام در منوی اصلی و درخواست ورودی کاربر</p>
</td>
</tr>
<tr>
<td width="64">
<p><strong>۴</strong></p>
</td>
<td width="198">
<p>TelegramMessage</p>
</td>
<td width="141">
<p>اضافه کردن مدل پیام‌رسانی تلگرام</p>
</td>
<td width="292">
<p>اضافه کردن مدل ارسال پیام برای تلگرام و گتر و ستر های فیلد چت ایدی</p>
</td>
</tr>
<tr>
<td width="64">
<p><strong>۵</strong></p>
</td>
<td width="198">
<p>SmsMessageService</p>
</td>
<td width="141">
<p>اورراید کردن تلگرام سرویس با بدنه خالی
</p>
</td>
<td width="292">
<p>
این به دلیل ساختار نامناسب کد می باشد</p>
</td>
</tr>

<tr>
<td width="64">
<p><strong>۶</strong></p>
</td>
<td width="198">
<p>EmailMessageService</p>
</td>
<td width="141">
<p>اورراید کردن تلگرام سرویس با بدنه خالی
</p>
</td>
<td width="292">
<p>
این به دلیل ساختار نامناسب کد می باشد</p>
</td>
</tr>

</tbody>
</table>

مجموع تعداد تغییرات: 6

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
کلاس TelegramMessage تنها مسئول نگهداری اطلاعات مربوط به پیام‌های تلگرام است. همچنین، کلاس TelegramMessageService تنها مسئول ارسال پیام‌های تلگرام است</p>
</td>
</tr>
<tr>
<td>
<p><strong>موارد نقض</strong></p>
</td>
<td>
<p>
در صورت اضافه کردن روش‌های پیام‌رسانی دیگر، نیاز به افزودن متدهای جدیدی به واسط MessageService خواهد بود که ممکن است این واسط را پیچیده کند.
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
با پیاده‌سازی کلاس‌های مستقل برای انواع مختلف پیام‌رسانی (SmsMessageService, EmailMessageService, TelegramMessageService)، این کلاس‌ها قابلیت توسعه دارند بدون اینکه نیاز به تغییر در کلاس‌های موجود باشد.
</p>
</td>
</tr>
<tr>
<td>
<p><strong>موارد نقض</strong></p>
</td>
<td>
<p>
.واسط MessageService باید برای هر نوع پیام جدید، تابعی اضافه کند که ممکن است تغییر در آن را در موارد آتی ضروری کند
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
کلاس‌های پیاده‌سازی می‌توانند به عنوان جایگزینی برای MessageService استفاده شوند و رفتار برنامه تحت تأثیر قرار نمی‌گیرد.
</p>
</td>
</tr>
<tr>
<td>
<p><strong>موارد نقض</strong></p>
</td>
<td>
<p>هر کلاس پیاده‌سازی MessageService باید متدهایی که نیاز ندارد را پیاده‌سازی کند، که ممکن است موجب نقض این اصل شود</p>
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
با توجه به جداسازی وظایف در کلاس‌های پیام‌رسانی مختلف، اصل جداسازی واسط به خوبی رعایت شده است.
</p>
</td>
</tr>
<tr>
<td>
<p><strong>موارد نقض</strong></p>
</td>
<td>
<p>
در واسط MessageService، متدهای پیام‌رسانی متفاوتی اضافه شده است که ممکن است برای کلاس‌های پیام‌رسانی خاصی غیرضروری باشند.
</p>
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
وابستگی کلاس‌های اصلی به واسط MessageService (به جای کلاس‌های پیام‌رسانی خاص) به خوبی رعایت شده است، که موجب افزایش انعطاف‌پذیری و قابلیت تست برنامه می‌شود.
</p>
</td>
</tr>
<tr>
<td>
<p><strong>موارد نقض</strong></p>
</td>
<td>
<p>
برای هر نوع پیام‌رسانی جدید، باید وابستگی‌های جدیدی اضافه شود که می‌تواند موجب نقض این اصل در آینده شود.
</p>
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
<p>اکنون علاوه بر مدیریت ارسال پیام‌ها، وظیفه‌ی تعریف و ساخت پیام‌ها نیز بر عهده‌ی کلاس اصلی (Main) قرار گرفته است..</p>
</td>
<td width="284">
<p>ایجاد یک کلاس جداگانه با نام MessageFactory که وظیفه‌ی ساخت انواع مختلف پیام‌ها (SMS، ایمیل، تلگرام) را بر عهده دارد و از آن در کلاس اصلی استفاده شود.</p>
</td>
</tr>
<tr>
<td width="168">
<p>OCP</p>
</td>
<td width="246">
<p>برای افزودن روش‌های جدید پیام‌رسانی، نیاز به تغییر در واسط MessageService داریم که این واسط را محدود به روش‌های خاص پیام‌رسانی می‌کند و OCP را نقض می‌کند.</p>
</td>
<td width="284">
<p>ایجاد واسط‌های جداگانه مانند SmsService، EmailService و TelegramService و حذف وابستگی مستقیم به MessageService در کلاس‌های پیام‌رسانی جدید برای انعطاف بیشتر</p>
</td>
</tr>
<tr>
<td width="168">
<p>LSP</p>
</td>
<td width="246">
<p>پیاده‌سازی‌های MessageService باید متدهایی که نیاز ندارند را پیاده‌سازی کنند، که این باعث پیچیدگی و نقض LSP می‌شود.</p>
</td>
<td width="284">
<p>استفاده از یک کلاس پایه AbstractMessageService که فقط متدهای ضروری را در خود دارد و پیاده‌سازی‌های خاص از آن ارث‌بری کنند تا از متدهای غیرضروری اجتناب شود.</p>
</td>
</tr>

<tr>
<td width="168">
<p>ISP</p>
</td>
<td width="246">
<p>واسط MessageService متدهای مختلفی برای انواع پیام‌رسانی دارد که برای همه‌ی کلاس‌ها قابل استفاده نیست و این اصل را نقض می‌کند.</p>
</td>
<td width="284">
<p>تقسیم واسط MessageService به واسط‌های کوچک‌تر و خاص هر نوع پیام‌رسانی برای جداسازی وظایف</p>
</td>
</tr>

<tr>
<td width="168">
<p>DIP</p>
</td>
<td width="246">
<p>کلاس اصلی (Main) مستقیماً به کلاس‌های پیام‌رسانی خاص وابسته است که موجب نقض این اصل می‌شود.</p>
</td>
<td width="284">
<p>ایجاد یک فکتوری یا استفاده از الگوی Dependency Injection برای تزریق وابستگی‌ها به کلاس اصلی به جای وابستگی مستقیم به کلاس‌های پیام‌رسانی خاص</p>
</td>
</tr>
</tbody>
</table>

### گام ۳: اصلاح موارد نقض
در نهایت، بر اساس تحلیلی که انجام داده‌اید و راه حل‌هایی که در بخش قبل ارایه کردید، کد را اصلاح کرده و بر روی مخزن گیت‌هاب و در پوشه‌ای مجزا از گام قبل commit و push کنید. انتظار می‌رود که تمامی راه حل‌های پیشنهادی خود را بر روی این نسخه اعمال کنید و تمامی بهبودهایی که انجام می‌دهید، در جداول بخش قبل موجود باشد.

### گام ۴: بررسی مجدد تغییرات مورد نیاز
فرض کنید که گام 1 را برای کد اصلاح شده (پس از انجام گام‌های ۲ و ۳) اجرا کرده‌اید.
1. در این صورت از انجام کدام یک از تغییرات ثبت شده در جدول گام ۱ معاف خواهید شد؟

در ساختار قدیمی، برای اضافه کردن پیام‌رسانی جدید، نیاز بود که:
- واسط `MessageService` تغییر کند و متد جدیدی برای واتساپ به آن اضافه شود که باعث پیچیدگی و نقض اصل ISP می‌شد.
- کلاس‌های دیگر مانند `Main` به صورت گسترده تغییر کنند تا از نوع پیام جدید پشتیبانی کنند.
- وابستگی‌های جدید به هر کلاس پیام‌رسانی اضافه شوند که نقض اصل DIP بود.

2. تعداد تغییرات مورد نیاز، چند تغییر خواهد شد؟

 **ایجاد مدل واتساپ**:
    - ایجاد یک کلاس جدید مانند `WhatsAppMessage` که ویژگی‌های خاص پیام‌های واتساپ را تعریف می‌کند (مانند `phoneNumber`).
    - این کلاس به عنوان مدل پیام‌های واتساپ عمل می‌کند و نیازی به تغییر در کدهای دیگر ندارد.

**ایجاد واسط واتساپ**:
    - ایجاد یک واسط جدید به نام `WhatsAppServiceInterface` که یک متد `sendWhatsAppMessage` داشته باشد.
    - این واسط تنها شامل متدهایی است که مختص پیام‌رسانی واتساپ است و از اضافه شدن متدهای غیرضروری جلوگیری می‌کند.

**پیاده‌سازی کلاس سرویس واتساپ**:
    - ایجاد کلاس `WhatsAppMessageService` که واسط `WhatsAppServiceInterface` را پیاده‌سازی کرده و متد `sendWhatsAppMessage` را پیاده‌سازی می‌کند.
    - این کلاس مسئولیت ارسال پیام واتساپ را بر عهده دارد و در ساختار فعلی نیازی به تغییر کدهای دیگر نیست.

**افزودن پشتیبانی به فکتوری**:
    - اضافه کردن نوع پیام جدید به `MessageFactory` برای ساختن `WhatsAppMessage`، که تنها به افزودن یک case جدید در متد `createMessage` محدود می‌شود.
    - این تغییر به سادگی امکان اضافه شدن نوع جدید پیام را فراهم می‌آورد بدون آنکه به تغییرات گسترده در ساختار کلی برنامه نیاز باشد.

### گام ۵: جمع بندی
در این بخش، بیان کنید که از این گام چه نتیجه‌ای گرفته‌اید؟ و به نظر شما به کارگیری صحیح اصول SOLID در گام‌های ۳ و ۴ چه مزایایی را نسبت به حالتی دارد که این اصول رعایت نشده‌بود؟

- **تغییرات به حداقل رسیده‌اند** و تنها شامل اضافه کردن کلاس‌ها و واسط‌های جدید برای پیام‌رسانی واتساپ است.
- **اصل Open-Closed** به خوبی رعایت شده است و می‌توان بدون تغییر در کلاس‌های موجود، قابلیت‌های جدید را اضافه کرد.
- **اصل Dependency Inversion** به خوبی رعایت شده و کلاس‌ها به واسط‌ها وابسته هستند، نه به پیاده‌سازی‌های خاص.

در نهایت، این ساختار باعث شده که اضافه کردن قابلیت جدید در سیستم با حداقل تغییرات و بدون نقض اصول SOLID امکان‌پذیر باشد.
