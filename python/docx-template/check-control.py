from docxtpl import DocxTemplate, RichText

tpl = DocxTemplate('templates/check-control.docx')
tpl.render(
    {
        'checked': False
    }
)
tpl.save('output/check-control.docx')
